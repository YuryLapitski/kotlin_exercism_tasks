import java.lang.IllegalArgumentException

class Dna(sequence: String) {

    private val dnaSequence: String = sequence
    private val validNucleotides = listOf('A', 'C', 'G', 'T')

    init {
        if (!dnaSequence.all { it in validNucleotides } && dnaSequence.isNotEmpty()) {
            throw IllegalArgumentException()
        }
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            val computedCounts = dnaSequence.groupBy { it }.mapValues { it.value.size }.toMutableMap()
            validNucleotides.forEach { computedCounts.putIfAbsent(it, 0) }
            return computedCounts
        }
}
