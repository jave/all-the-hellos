# using Base.Test

# include("hello-world.jl")

# @testset "Say Hi!" begin
#     @test hello() == "Hello, World!"
# end



using Test

include("hello-world.jl")

@testset "Say Hi!" begin
    @test hello() == "Hello, World!"
end
