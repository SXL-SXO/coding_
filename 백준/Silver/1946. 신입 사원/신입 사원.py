import sys
from collections import deque

T=sys.stdin.readline()
T=int(T)

for z in range(T):
    N=sys.stdin.readline()
    N=int(N)

    poss=0
    imposs=0

    best=N+1
    sample=[]
    
    for _ in range(N):
        sample.append(list(map(int,sys.stdin.readline().split())))
    
    sample.sort()
    
    for i in range(N):        
        if sample[i][1]<best:
            poss+=1
            best=sample[i][1]
        else:
            imposs+=1
    if poss+imposs==N:
        print(poss)
        
    