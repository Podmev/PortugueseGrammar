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

Additional engine features
 - silaba tonica, stress
 - genders of nouns


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
 - Similar verbs have the same conjugation or no, after answer can show difference
 - Tests for multiple correct forms
 - Test for brazilian/portuguese version
   - by form need to understand, which language form is from
   - write forms for brazil/portugal
 - Compare forms of 2 verbs
 - Tests for forms with diacritics
 - Tests for choosing tense by description (when we use tense) and opposite
 - Tests for choosing correct tense by model of changing
 - Report form for wrong test or information
 - Tests configurator with filters
 - Test chapters, like in book. Every can have multiple tests inside
 - Mode to start from zero or inicial test
 - Marking verb unknown during tests
 - In the bottom several sections
   - Chapters
   - Test configurator
   - Wiki
   - Progress
   - Profile
 - Progress
   - Experience 
   - General 
   - Chapters
   - Tenses
   - Verbs
     - global
     - by each set of verbs by frequency: 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, all
     - other list of verbs
   - dates of activities about verbs/tenses/chapters
 - Wiki
   - description about tenses, rules, exceptions
   - search of verb
   - different list of verbs
   - randomizer of verbs
   - randomizer of rules
   - cross button to start test about it
   - current progress of selected rule or verb
   - show new words
 - Possible app names
   - ConjugateMaster
   - Verblingo
   - VerbQuiz
   - ConjugationQuiz
   - VerbMaster (already exists )
   - Portuguese Verb Master
 - Logo idea
   - Hedgehog with glasses
 - Challenges
   - first step: try one test
   - Tries all verbs to conjugate
     - by percent (10, 20, ... 100)
   - tried all types of tests
   - tried all tenses
   - construct your test by filters
   - Portuguese-Bilingual: tries both language versions
   - Curiosity: turn-on forms for vos and use for some tests
   - Bad bay: fail several tests in row
   - strike(2, 3, 7, 14, 30, 365)
   - reporter: report about mistake
   - suggester: suggest new type of test
   - memories: 
     - save some verbs (10) in bookmarks
     - save some custom tests (3)
     - save some verb lists (3)
   - absolute unit: make correct some part of tests by day or amount
   - blacklist: add some verbs to black list
   - passed all education in tree
   - night bird: pass test during night 00:00-06:00
   - publisher: share your test
   - best-seller: 100 people passed your test
 - Support teacher-students feature
   - different type of account for teacher and student
   - add student to teacher, add teacher to student
   - teacher can see activity of student
   - homework with due date
     - teacher send tests for student
     - notification for student
     - send date for teacher to student
     - due date for student
     - reminder of soon due date
     - see result for teacher of each student and statistic among all students
     - choose mark system for grading
     - scheduled homework with preplan, only current homework is available for student
     - view homework result along the plan
 
   

 Links
 https://github.com/jalvesaq/gconjugue
 https://github.com/ian-hamlin/verb-data
 https://www.conjugacao.com.br/verbos-regulares/
 https://www.conjugacao.com.br/verbos-irregulares/
 https://blog.flaviarita.com/51-verbos-que-vao-cair-na-sua-prova-portugues-para-concurso/#.Y09icHZBwzM
 https://portuguesaletra.com/artigos/verbos-mais-usados-em-portugues/


similar projects
https://www.verbmaster.co/
https://play.google.com/store/apps/details?id=com.learningfrenchphrases.verbmaster&hl=en&gl=US


Gradle
https://tomgregory.com/10-tips-to-use-gradle-with-intellij-idea/

ci-cd
https://tomgregory.com/build-gradle-projects-with-github-actions/
https://proandroiddev.com/how-do-i-setup-github-actions-for-my-gradle-or-android-project-17af6f2fac59


the underlying problem is that the file is not executable, which you'll need to change in your repository. If you're on Windows, that may be why the file did not get added as executable in your repository. On Windows, you can run:

    git update-index --chmod=+x gradlew
Then commit and push this change.