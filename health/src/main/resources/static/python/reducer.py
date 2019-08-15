import sys
import json

path = sys.argv[1]
array=[]
for line in sys.stdin:
    temp=line.strip().split("\t")
    temp = list(filter(lambda s:s.strip(),temp))
    canInAppend = True
    for a in array:
        if a[0]==temp[0]:
            canInAppend = False
            a[1]=float(a[1])+float(temp[1])
    if canInAppend:
        array.append(temp)
with open(path+"result.txt",'w',encoding="utf-8") as fpp:
    for a in array:
        string = ''
        for i in a:
            string = string + str(i) + "\t"
        string+="\n"
        fpp.write(string)
