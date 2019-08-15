import sys
import re
import json


def countDimension(Array):
    size = {}
    for a in Array:
        if size.get(len(a),0) != 0:
            size[len(a)] += 1
        else:
            size[len(a)]=1
    max = 0
    max_size = 0
    for k,v in size.items() :
        if v>max:
            max = v
            max_size = k
    return max_size
path = sys.argv[1]
# fileName = sys.argv[2]
array = []
try:
    with open(path+"input.txt","r",encoding="utf-8") as fp:
        while True:
            line = fp.readline()
            if not line or line=="":
                break
            temp = re.split(r",| |\t",line)
            result = []
            for t in temp:
                result.append(t.strip())
            while result.count("")>0:
                result.remove("")
            array.append(result)
    common_size = countDimension(array)
    array = list(filter(lambda x:len(x)==common_size,array))
    for a in array:
        string = ''
        for i in a:
            string = string+str(i)+"\t"
        print(string)

except Exception as e:
    print(e)
    with open(path +"input.txt","r",encoding="gbk") as fp:
        while True:
            line = fp.readline()
            if not line or line=="":
                break
            temp = re.split(",| ", line)
            result = []
            for t in temp:
                result.append(t.strip())
            while result.count("") > 0:
                result.remove("")
            array.append(result)
        common_size = countDimension(array)
        array = list(filter(lambda x: len(x) == common_size, array))
        for a in array:
            string = ''
            for i in a:
                string = string + str(i) + "\t"
            print(string)
