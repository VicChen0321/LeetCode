import heapq

class FoodRatings:
    def __init__(self, foods, cuisines, ratings):
        self.foodToCuisine = {}
        self.foodToRating = {}
        self.cuisineToHeap = {}

        for f, c, r in zip(foods, cuisines, ratings):
            self.foodToCuisine[f] = c
            self.foodToRating[f] = r

            if c not in self.cuisineToHeap:
                self.cuisineToHeap[c] = []
            
            # push: (-rating, foodName)
            heapq.heappush(self.cuisineToHeap[c], (-r, f))

    def changeRating(self, food, newRating):
        cuisine = self.foodToCuisine[food]
        self.foodToRating[food] = newRating
        heapq.heappush(self.cuisineToHeap[cuisine], (-newRating, food))

    def highestRated(self, cuisine):
        heap = self.cuisineToHeap[cuisine]
        # Delay delete: make sure top element is latest rating
        while heap:
            rating, food = heap[0]
            if -rating == self.foodToRating[food]:
                return food
            heapq.heappop(heap)
