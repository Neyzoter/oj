k=int(input())
n=int(input())
w=list(map(int,input().strip().split()))
v=list(map(int,input().strip().split()))
dp=[0]*(k+1)
for i in range(n):
    for j in range(k,w[i]-1,-1):
        dp[j]=max(dp[j],dp[j-w[i]]+v[i])
for i in range(k,-1,0):
    if dp[j]!=0:
        print(dp[j])
        break
