n,k=list(map(int,input().strip().split()))
print(' '.join(map(str,list(range(n-k+1,n+1))+list(range(1,n-k+1)))))