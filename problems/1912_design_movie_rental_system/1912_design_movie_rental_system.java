class MovieRentingSystem {

    private final Map<Integer, TreeSet<Entry>> movieToShops;
    private final Map<String, Integer> shopMovieToPrice;
    private final TreeSet<Entry> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        movieToShops = new HashMap<>();
        shopMovieToPrice = new HashMap<>();
        rented = new TreeSet<>();
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            shopMovieToPrice.put(shop + "#" + movie, price);
            movieToShops.computeIfAbsent(movie, k -> new TreeSet<>())
                    .add(new Entry(price, shop, movie));
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!movieToShops.containsKey(movie))
            return res;
        int count = 0;
        for (Entry e : movieToShops.get(movie)) {
            res.add(e.shop);
            if (++count == 5)
                break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = shopMovieToPrice.get(shop + "#" + movie);
        Entry e = new Entry(price, shop, movie);
        movieToShops.get(movie).remove(e);
        rented.add(e);
    }

    public void drop(int shop, int movie) {
        int price = shopMovieToPrice.get(shop + "#" + movie);
        Entry e = new Entry(price, shop, movie);
        rented.remove(e);
        movieToShops.get(movie).add(e);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (Entry e : rented) {
            res.add(Arrays.asList(e.shop, e.movie));
            if (++count == 5)
                break;
        }
        return res;
    }

    private static class Entry implements Comparable<Entry> {
        int price, shop, movie;

        Entry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }

        @Override
        public int compareTo(Entry other) {
            if (this.price != other.price)
                return Integer.compare(this.price, other.price);
            if (this.shop != other.shop)
                return Integer.compare(this.shop, other.shop);
            return Integer.compare(this.movie, other.movie);
        }
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */