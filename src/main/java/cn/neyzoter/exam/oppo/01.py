n=int(input())
if n<6:print("null")
else:
    sweet=[]
    for i in range(n):
        a,b=list(map(int,input().strip().split()))
        sweet.append([a,b])
    red_first_num=red_second_num=red_third_num=blue_first_num=blue_second_num=bule_third_num=0
    red_first_index=red_second_index=red_third_index=blue_first_index=blue_second_index=bule_third_index=-1
    i=0
    for sweet_num,color in sweet:
        if color==1:
            if sweet_num>=red_first_num:
                red_third_num=red_second_num
                red_third_index=red_second_index
                red_second_num=red_first_num
                red_second_index=red_first_index
                red_first_num=sweet_num
                red_first_index=i
            elif sweet_num>=red_second_num:
                red_third_num=red_second_num
                red_third_index=red_second_index
                red_second_num=sweet_num
                red_second_index=i
            elif sweet_num>=red_third_num:
                red_third_num=sweet_num
                red_third_index=i
        else:
            if sweet_num>=blue_first_num:
                blue_third_num=blue_second_num
                blue_third_index=blue_second_index
                blue_second_num=blue_first_num
                blue_second_index=blue_first_index
                blue_first_num=sweet_num
                blue_first_index=i
            elif sweet_num>=blue_second_num:
                blue_third_num=blue_second_num
                blue_third_index=blue_second_index
                blue_second_num=sweet_num
                blue_second_index=i
            elif sweet_num>=blue_third_num:
                blue_third_num=sweet_num
                blue_third_index=i
        i+=1
    red_first_index+=1
    red_first_num+=1
    red_third_index+=1
    blue_first_index+=1
    blue_second_index+=1
    blue_third_index+=1
    if (red_first_index==0 or red_second_index==0 or red_third_index==0) and (blue_first_index==0 or blue_second_index==0 or blue_third_index==0):
        print("null")
    elif (red_first_index==0 or red_second_index==0 or red_third_index==0) and (blue_first_index!=0 and blue_second_index!=0 and blue_third_index!=0):
        print(sorted([blue_first_index,blue_second_index,blue_third_index]))
        print(2)
        print(blue_first_num+blue_second_num+blue_third_num)
    elif red_first_index!=0 and red_second_index!=0 and red_third_index!=0 and (blue_first_index==0 or blue_second_index==0 or blue_third_index==0):
        print(sorted([red_first_index,red_second_index,red_third_index]))
        print(1)
        print(red_first_num+red_second_num+red_third_num)
    else:
        if red_first_num+red_second_num+red_third_num>blue_first_num+blue_second_num+blue_third_num:
            print(sorted([red_first_index,red_second_index,red_third_index]))
            print(1)
            print(red_first_num+red_second_num+red_third_num)
        elif red_first_num+red_second_num+red_third_num<blue_first_num+blue_second_num+blue_third_num:
            print(sorted([blue_first_index,blue_second_index,blue_third_index]))
            print(2)
            print(blue_first_num+blue_second_num+blue_third_num)
        else:
            red_index=min(red_first_index,red_second_index,red_third_index)
            blue_index=min(blue_first_index,blue_second_index,blue_third_index)
            if red_index<blue_index:
                print(sorted([red_first_index,red_second_index,red_third_index]))
                print(1)
                print(red_first_num+red_second_num+red_third_num)   
            else:
                print(sorted([blue_first_index,blue_second_index,blue_third_index]))
                print(2)
                print(blue_first_num+blue_second_num+blue_third_num)