def solution(array, target):
    all_ways = []

    def get_all_ways_by_doing_plus_or_minus(array, current_index, current_sum):
        if current_index == len(array):
            all_ways.append(current_sum)
            return
        get_all_ways_by_doing_plus_or_minus(array, current_index+1, current_sum + array[current_index])
        get_all_ways_by_doing_plus_or_minus(array, current_index+1, current_sum - array[current_index])

    get_all_ways_by_doing_plus_or_minus(array, 0, 0)
    target_count = 0
    for way in all_ways:
        if target == way:
            target_count +=1
    return target_count