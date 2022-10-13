import Base: +, -, *, /
import Base: imag, real, abs, conj
import Base: ==, ≈

struct ComplexNumber <: Number
    re::Real
    im::Real
end

ComplexNumber(r,i)= begin
    re=r
    im=i
end


+(a::ComplexNumber,b::ComplexNumber)=ComplexNumber(a.re+b.re, a.im+b.im)
-(a::ComplexNumber,b::ComplexNumber)=ComplexNumber(a.re-b.re, a.im-b.im)

#(a + bi)(c + di) = ac+adi+bic+bidi = ac-b + adi+bic
#(a.re+a.im)(b.re+b.im) = a.re*b.re +  a.im*b.im + a.re*b.im + a.im*b.re
*(a::ComplexNumber,b::ComplexNumber)= ComplexNumber(a.re*b.re-a.im*b.im , a.re*b.im+a.im*b.re)

function /(a::ComplexNumber,b::ComplexNumber)
    ComplexNumber((a.re*b.re + a.im*b.im) / (b.re^2+b.im^2) ,
                  (a.im*b.re - a.re*b.im) / (b.re^2+b.im^2))
end;

abs(z::ComplexNumber)=hypot(z.re,z.im) # hypot=hypotenuse
real(z::ComplexNumber)= z.re
imag(z::ComplexNumber)=  z.im
conj(a::ComplexNumber)=ComplexNumber(a.re , -a.im)

# these are needed for the tests to pass, which i find odd
# sure we need these in common usage, but tests imho shouldnt use impl code to for testing
≈(x::ComplexNumber, y::ComplexNumber) = isapprox(x.re, y.re) && isapprox(x.im, y.im)
==(z::ComplexNumber, w::ComplexNumber) = z.re == w.re && z.im == w.im

# no bonus exercise yet...
