# a. The minimal length of such a string is 10003, assuming maximum overlap
#    A more general formula is 10^n + n - 1

def permute_keystring(n):
    count = 1
    target_count = 10 ** n
    seen = [False] * (10 ** n) # track numbers already in the answer

    ans = [0] * n # init the answer
    seen[0] = True # init the seen array

    digit_to_add = 0 # tracks the digit we're considering adding to the number
    while count < target_count:
        added = False
        while not added and digit_to_add < 10:
            # go through 10 digits, check if exists already
            if seen[int_list_to_number(ans[-(n-1):])*10 + digit_to_add]:
                # we saw the current number already, try another digit
                digit_to_add += 1
            else:
                # we haven't seen the current number, add the digit
                ans.append(digit_to_add)
                count += 1
                seen[int_list_to_number(ans[-n:])] = True
                added = True
                digit_to_add = 0
         
        if digit_to_add >= 10:
            # passed 10: backtrack and try again
            seen[int_list_to_number(ans[-n:])] = False
            digit_to_add = ans[-1] + 1
            ans = ans[:-1]
            count -= 1

        print arr_to_string(ans)

    return arr_to_string(ans)

# utility functions
def int_list_to_number(arr):
    ans = 0
    for x in arr:
        ans *= 10
        ans += x
    return ans

def arr_to_string(arr):
    return ''.join(map(str, arr))

if __name__ == '__main__':
    print permute_keystring(3)