import sys

input = sys.stdin.read().strip()

def find_count_to_turn_out_to_all_zero_or_all_one(string):
    # 연속된 숫자인지 확인
    turn_zero = 0
    successive_zero = False
    successive_one = False
    turn_one = 0

    for element in string:
        # 0을 뒤집자
        if element == '0':
            if not successive_zero:
                turn_zero+=1
                successive_zero = True
        else:
            successive_zero = False

    for element in string:
        # 1을 뒤집자
        if element == '1':
            if not successive_one:
                turn_one+=1
                successive_one = True
        else:
            successive_one = False
    return min(turn_zero, turn_one)

result = find_count_to_turn_out_to_all_zero_or_all_one(input)
print(result)