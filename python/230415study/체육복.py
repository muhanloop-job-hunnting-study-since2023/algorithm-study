def solution(n, lost, reserve):
    #여벌자가 도난당하는경우
    reallost = set(lost)  - set(reserve)
    print(reallost)
    realreserve= set(reserve) - set(lost)
    print(realreserve)
    
    # 해결되는 lost 건수 체크로직 
    for i in reallost:
        if i - 1 in realreserve:
            realreserve.remove(i - 1)
        elif i + 1 in realreserve:
            realreserve.remove(i + 1)
        #해결안됨 n -1 
        else:
            n-=1
    return n
    
    
    '''
    오류 풀이. 
    reserve 기준으로 풀이 했다가 
    너무돌아가는거같아서 포기
    
    uniforms = [0] * n
    for uni in reserve: 
        if uni-1>-1:
            #print(uni-1)
            uniforms[uni-1] = uniforms[uni-1]+1
        
        if uni < n:
            #print(uni)
            uniforms[uni] = uniforms[uni]+1
            
        if uni+1 < n:
            #print(uni)
            uniforms[uni+1] = uniforms[uni+1]+1
        
    #for l in lost:
    #    if l
    print( uniforms)
    
    answer = 0
    return answer
    '''
    
