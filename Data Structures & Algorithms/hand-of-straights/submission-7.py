class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize:
            return False

        count = Counter(hand)
        

        for num in hand: 
            start = num
            while count[start - 1]:
                start -= 1
            if not count[start]:
                continue
            for num in range(start, start + groupSize):
                if count[num] <= 0:
                    return False
                count[num] -= 1

        return True
