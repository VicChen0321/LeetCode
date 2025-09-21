class MovieRentingSystem:

    def __init__(self, n: int, entries: List[List[int]]):
        self.movieToShops = {}
        self.shopMovieToPrice = {}
        self.rented = SortedList()

        for shop, movie, price in entries:
            self.shopMovieToPrice[(shop, movie)] = price
            if movie not in self.movieToShops:
                self.movieToShops[movie] = SortedList()
            self.movieToShops[movie].add((price, shop))

    def search(self, movie: int) -> list[int]:
        if movie not in self.movieToShops:
            return []
        return [shop for price, shop in self.movieToShops[movie][:5]]

    def rent(self, shop: int, movie: int) -> None:
        price = self.shopMovieToPrice[(shop, movie)]
        self.movieToShops[movie].remove((price, shop))
        self.rented.add((price, shop, movie))

    def drop(self, shop: int, movie: int) -> None:
        price = self.shopMovieToPrice[(shop, movie)]
        self.rented.remove((price, shop, movie))
        self.movieToShops[movie].add((price, shop))

    def report(self) -> list[list[int]]:
        return [[shop, movie] for price, shop, movie in self.rented[:5]]


# Your MovieRentingSystem object will be instantiated and called as such:
# obj = MovieRentingSystem(n, entries)
# param_1 = obj.search(movie)
# obj.rent(shop,movie)
# obj.drop(shop,movie)
# param_4 = obj.report()