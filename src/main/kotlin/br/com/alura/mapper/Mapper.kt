package br.com.alura.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
