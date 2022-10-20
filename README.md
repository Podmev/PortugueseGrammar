# PortugueseGrammar
Grammatic engine for Brazilian Portuguese

Main part is about verbs

Things to do:
 - Find data for all verbs in all conjugation forms, like big dictionary in file
 - Find list of verbs
 - validate input data (verbs and forms)
 - find list of verbs ordered by using frequency
 - Create conjugator for verbs with params: verb infinitive, pronoun, tense
 - create tests checking that conjugator works correct
 - most of the forms should be evaluated analytically, exceptions should be saved in separate dicts

 Future development of engine
 - make lib
 - publish lib
 - make rest-api
 - deploy conjugation service with rest-api
 - deploy site with verb form constructor, quiz
 - support other languages' grammar (with similar grammar) - Italian, French, Spanish

 Architecture:
  - enums for pronouns
  - enums for tenses and grammatic forms
  - structure for all forms for one verb


Quiz App (next project) - Conjugation test
 - For verb make all conjugation for all tenses and pronouns
 - It can be like small spreadsheet or one by one random
 - By verb in form say which is pronoun, tense and voice
 - By verb say which is infinitive
 - By verb in some form write verb in other form
 - Settings with which tenses can be used
 - Test for irregular verbs
 - Save progress of verbs, frequency of usage
 - Choose random verb, or go to next
 - Test for ordering list of verb forms according to tenses
 - Test by tenses or by verbs or by pronoun
 - Choose tense in list by verb in form (can be all tenses or just part)
 - Change verb to indirect speech


 Links
 https://github.com/jalvesaq/gconjugue
 https://github.com/ian-hamlin/verb-data
 https://www.conjugacao.com.br/verbos-regulares/
 https://www.conjugacao.com.br/verbos-irregulares/
 https://blog.flaviarita.com/51-verbos-que-vao-cair-na-sua-prova-portugues-para-concurso/#.Y09icHZBwzM
 https://portuguesaletra.com/artigos/verbos-mais-usados-em-portugues/


Gradle
https://tomgregory.com/10-tips-to-use-gradle-with-intellij-idea/
