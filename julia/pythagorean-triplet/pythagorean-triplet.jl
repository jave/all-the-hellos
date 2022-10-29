using Printf;


#this naive approach works, buts too slow for the exercism testrunner
# function pythagorean_triplets(N)
#     rv=[]
#     loops=0
#     for c in 1:N
#         for b in 1:c
#             for a in 1:b
#                 loops+=1
#                 sum_eq_N=(a+b+c==N)
#                 is_pythagorean=(a^2+b^2==c^2)
#                 if(sum_eq_N  & is_pythagorean)
#                     @printf("%d %d %d abc:%d\n",a,b,c, sum_eq_N )
#                     push!(rv,(a,b,c))
#                 end
#             end
            
#         end
        
#     end
#     println(loops)
#     rv
# end

# this is a bit more optimized
# the criteria form an equation system like this:
# a+b+c=N
# a^2+b^2=c^2

# c=N-a-b
# c=sqrt(a^2+b^2)

# (N-a)-b = sqrt(a^2+b^2)

# (N-a)^2-2(N-a)b+b^2 = a^2+b^2
# -2(N-a)b = a^2- (N-a)^2
# b= (a^2- (N-a)^2)/-2(N-a)
#(a^2- (N-a)^2)
#a² - (N^2-2Na+a^2 )
#-N^2+2Na
#-N*(N+2a)
function pythagorean_triplets(N)
    rv=[]
    loops=0
    for a in 1:N
        b, reminder= divrem(N*(N-2*a), 2*(N-a))
        a<=b||break 
        c=N-a-b
        
        loops+=1
        sum_eq_N=((a+b+c)==N)
        is_pythagorean=(a^2+b^2==c^2)
        if(sum_eq_N  && is_pythagorean && reminder==0)
            @printf("a=%d b=%d c=%d a+b+c=%d reminder=%d\n",a,b,c, sum_eq_N, reminder )
            push!(rv,(a,b,c))
        end
        
    end
    println(loops)
    rv
end

