class Solution:
    def minTime(self, skill: List[int], mana: List[int]) -> int:
        sumSkill = sum(skill)
        prevWizardDone = sumSkill * mana[0]

        for j in range(1, len(mana)):
            prevPotionDone = prevWizardDone
            for i in range(len(skill) - 2, -1, -1):
                prevPotionDone -= skill[i + 1] * mana[j - 1]
                candidate = prevWizardDone - skill[i] * mana[j]
                prevWizardDone = max(prevPotionDone, candidate)
            prevWizardDone += sumSkill * mana[j]

        return prevWizardDone
