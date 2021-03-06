def product(f: Int => Int)(a :Int , b:Int) :Int  = {
    if (a > b) { 
        1
    } else {
        f(a) * product(f)(a+1, b)
    }
}


product(x=>(x*x))(1, 3)


def mapReduce(f: Int=> Int, combine : (Int, Int) => Int, zero : Int)(a: Int, b : Int) : Int = {
    def recur (a : Int) : Int = 
        if (a > b ) {
            zero
        } else {
            combine(f(a), recur(a+1))
        }
    recur(a)
}

def sum(f: Int=> Int)(a: Int, b:Int) : Int = mapReduce(f, (x, y) => x+y , 0)(a, b)

sum(x => x*x)(3, 4)