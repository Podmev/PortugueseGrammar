# PortugueseGrammar
Grammatical engine for Brazilian Portuguese

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
  - enums for tenses and grammatical forms
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
 - For each tense create separate groups of verb and verbArguments by different rules + irregulars. So in test we can mix well verbs from different rules or practice only one
 - For errors show rules, show how worked congratulation
 - Test for full 4-6 forms at ones
   - To fill full 
   - To swipe left or right for full set of forms, correct or wrong. Can be mixed with forms from wrong tenses or sumilar verbs
   - Test for subset of forms, for example 2 or 3
   - Rearrange forms randomly
 - Choose rules to conjugate from list, can be several
 - Decide two forms of verb are from the same verb
 - Verb is regular or no
 - Verbs are the same tense or no
 - Verbs are the same person/number
 - Defective verb, show which forms don't exist
 - Similar verbs have thу same conjugation or no, after answer can show difference
 - Compare forms of 2 verbs
 - Tests for forms with diacritics
 - Report form for wrong test or information
 - Tests configurator with filters
 - Test chapters, like in book. Every can have multiple tests inside
 - Mode to start from zero or inicial test
 - In the bottom several sections
   - Chapters
   - Test configurator
   - Wiki
   - Profile
 - Progress
   - Chapters
   - Tenses
   - Verbs

 Links
 https://github.com/jalvesaq/gconjugue
 https://github.com/ian-hamlin/verb-data
 https://www.conjugacao.com.br/verbos-regulares/
 https://www.conjugacao.com.br/verbos-irregulares/
 https://blog.flaviarita.com/51-verbos-que-vao-cair-na-sua-prova-portugues-para-concurso/#.Y09icHZBwzM
 https://portuguesaletra.com/artigos/verbos-mais-usados-em-portugues/


Gradle
https://tomgregory.com/10-tips-to-use-gradle-with-intellij-idea/

ci-cd
https://tomgregory.com/build-gradle-projects-with-github-actions/
https://proandroiddev.com/how-do-i-setup-github-actions-for-my-gradle-or-android-project-17af6f2fac59


the underlying problem is that the file is not executable, which you'll need to change in your repository. If you're on Windows, that may be why the file did not get added as executable in your repository. On Windows, you can run:

    git update-index --chmod=+x gradlew
Then commit and push this change.