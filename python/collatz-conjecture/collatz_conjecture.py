# The Collatz Conjecture or 3x+1 problem can be summarized as follows:

# Take any positive integer n. If n is even, divide n by 2 to get n / 2. If n is odd, multiply n by 3 and add 1 to get 3n + 1. Repeat the process indefinitely. The conjecture states that no matter which number you start with, you will always reach 1 eventually.

# Given a number n, return the number of steps required to reach 1.

#old one, that worked before
# def collatz_steps(n):
#     step=0
#     if n<=0:
#         raise ValueError("bad value")
#     while not (n == 1):
#         #print(step, n)
#         step=step+1
#         if n % 2 == 0: #even
#             n = n /2
#         else:
#             n = n * 3 + 1
#     return step
        
#some changes because exercism changed their tests
def steps(n):
    step=0
    if n<=0:
        raise ValueError("Only positive integers are allowed")
    while not (n == 1):
        #print(step, n)
        step=step+1
        if n % 2 == 0: #even
            n = n /2
        else:
            n = n * 3 + 1
    return step
