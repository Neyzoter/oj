n,m=list(map(int,input().strip().split(",")))
grid=[]
for i in range(n):
    now=input()
    now1=[]
    for j in now:now1.append(j)
    grid.append(now1)
res=0
print(grid)
dx,dy=[1,-1,0,0],[0,0,1,-1]
def dfs(x,y):
    grid[x][y]='H'
    for i in range(4):
        xx,yy=x+dx[i],y+dy[i]
        if xx>=0 and yy>=0 and xx<n and yy<m and grid[xx][yy]=='S':
            dfs(xx,yy)
for i in range(n):
    for j in range(m):
        if grid[i][j]=='S':
            res+=1
            dfs(i,j)
print(res)