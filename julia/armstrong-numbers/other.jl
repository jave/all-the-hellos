
              

# get a particular digit from a number: digit(123,1) => 2.0

        

          

# it sort of works like bitmasking, but decimal

        

          

digit(n,i)=trunc(n/10^i) - trunc(n/10^(i+1))*10

        

          


        

          

numlen(n)=length(string(n))

        

          


        

          

function numtodigits(n)

        

          

    numdigits=[]

        

          

    for i in 0:numlen(n)-1 push!(numdigits,digit(n,i)) end

        

          

    numdigits

        

          

end

        

          


        

          

armstrongsum(n)=sum(map((x)->x^numlen(n),numtodigits(n) ))

        

          


        

          

function isarmstrong(n)

        

          

    armstrongsum(n)==n

        

          

end
