object Luhn {

    fun isValid(candidate: String): Boolean {
        if (candidate.isBlank()) return false

        val escapedSpacesCandidate = candidate.replace(" ", "")

        if (escapedSpacesCandidate.length <= 1 || escapedSpacesCandidate.any { !it.isDigit() }) return false

        val candidateList = escapedSpacesCandidate.toList().map { Character.getNumericValue(it) }.reversed()

        val sum = candidateList.mapIndexed { index, value ->
            when (index % 2) {
                0 -> value
                else -> {
                    val doubledDigit = value * 2
                    when {
                        doubledDigit > 9 -> doubledDigit - 9
                        else -> doubledDigit
                    }
                }
            }
        }.sum()

        return sum % 10 == 0
    }
}
