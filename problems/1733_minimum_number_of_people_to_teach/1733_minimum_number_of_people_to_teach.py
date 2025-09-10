class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friendships: List[List[int]]) -> int:
        user_languages = [set(langs) for langs in languages]
        need_to_teach = set()
        for u, v in friendships:
            u -= 1
            v -= 1
            if user_languages[u].isdisjoint(user_languages[v]):
                need_to_teach.add(u)
                need_to_teach.add(v)
        language_count = defaultdict(int)
        for user in need_to_teach:
            for lang in user_languages[user]:
                language_count[lang] += 1
        max_known = max(language_count.values(), default=0)
        return len(need_to_teach) - max_known