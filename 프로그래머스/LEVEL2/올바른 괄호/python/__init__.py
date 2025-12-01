def solution(string):
    stack_left = []
    for str in string:
        if str == ")" :
            if len(stack_left) == 0:
                return False
            else:
                stack_left.pop()
        else:
            stack_left.append(str)
    return len(stack_left) == 0