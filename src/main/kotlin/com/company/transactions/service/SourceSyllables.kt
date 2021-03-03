package com.company.transactions.service

class SourceSyllables {

    companion object {
        private val syllables : HashMap<Int, String> = HashMap()

        init {
            this.loadSyllables()
        }

        fun get(index: Int): String? {
            if(index > syllables.size) {
                val newIndex = (index / syllables.size)
                return syllables[newIndex]
            }
            return syllables[index]
        }

        fun size(): Int = syllables.size

        fun listaTabelaSilabas() {
            for(key in syllables.keys) {
                println("$key - ${syllables[key]}")
            }
        }

        private fun loadSyllables() {
            val lowerCaseAlphabetAsciiCode = 97..122
            val vowelsAsciiCode = arrayListOf(97, 101, 105, 111, 117)

            val consonants = lowerCaseAlphabetAsciiCode.filterNot { vowelsAsciiCode.contains(it) }.map { it.toChar() }
            val vowels = lowerCaseAlphabetAsciiCode.filter { vowelsAsciiCode.contains(it) }.map { it.toChar() }

            var count = 1
            for(consonant in consonants) {
                for(vowel in vowels) {
                    syllables[count] = "$consonant$vowel"
                    count++
                }
            }
        }
    }

}