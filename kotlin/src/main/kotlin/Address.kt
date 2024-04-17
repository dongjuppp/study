package org.example

data class Address(
    val city: String,
) {

    fun isAroundAddress(address: Address): Boolean {
        return this.city == address.city
    }

}
