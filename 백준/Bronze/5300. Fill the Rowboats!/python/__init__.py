N = int(input())

result = []

for i in range(1, N + 1):
    result.append(str(i))
    if i % 6 == 0:
        result.append("Go!")

if N % 6 != 0:
    result.append("Go!")

print(" ".join(result))
