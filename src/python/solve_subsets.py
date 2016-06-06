def avgset(A):
    def find_subset(S, set1, set2, sum1):
        if sum1 > len(set1):
            return None
        
        if set1 and set2 and len(set1) == sum1:
            return [set1, set2 + S]
        
        if not S:
            return None
            
        res = find_subset(S[1:], set1 + [S[0]], set2, sum1 + S[0])
        
        if not res:
            res = find_subset(S[1:], set1, set2 + [S[0]], sum1)
        
        return res
    
    
    if not A:
        return []
        
    avg = sum(A) * 1.0 / len(A)
    
    a = sorted([x/avg for x in A])
        
    result = find_subset(a, [], [], 0)
    
    if not result:
        return []

    r1 = [int(avg * x) for x in result[0]]
    r2 = [int(avg * x) for x in result[1]]
    
    if len(r1) < len(r2):
        return [r1, r2]
    else:
        return [r2, r1]
    
A = [ 13, 30, 9, 13, 17, 42, 28, 20, 9, 24, 14, 20, 1, 28, 24, 26, 45, 27, 34, 38, 48, 38, 7, 34 ]

print avgset(A)