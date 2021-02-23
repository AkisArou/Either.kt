interface FoldObject<L, R> {
    fun onSuccess(value: R)
    fun onFailure(error: L)
}

sealed class Either<L, R>(open val error: L, open val value: R) {
    fun fold(foldObject: FoldObject<L, R>) {
        when (this) {
            is Left -> foldObject.onFailure(this.error)
            is Right -> foldObject.onSuccess(this.value)
        }
    }
}

data class Left<L : Throwable>(override val error: L) : Either<L, Unit>(error, Unit)
data class Right<R>(override val value: R) : Either<Unit, R>(Unit, value)

fun <L : Throwable, R> left(x: L) = Left(x) as Either<L, R>
fun <L : Throwable, R> right(x: R) = Right(x) as Either<L, R>

