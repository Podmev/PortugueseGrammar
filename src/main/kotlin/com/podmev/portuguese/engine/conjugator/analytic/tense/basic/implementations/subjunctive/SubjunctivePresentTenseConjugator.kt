package com.podmev.portuguese.engine.conjugator.analytic.tense.basic.implementations.subjunctive

import com.podmev.portuguese.data.engine.conjugator.*
import com.podmev.portuguese.data.grammar.term.verb.VerbArguments
import com.podmev.portuguese.engine.conjugator.analytic.*
import com.podmev.portuguese.engine.utils.verb.VerbEnds

/*
[241] VerbFormInfo(infinitive=abolir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[242] VerbFormInfo(infinitive=abolir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[243] VerbFormInfo(infinitive=abolir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[244] VerbFormInfo(infinitive=abolir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[245] VerbFormInfo(infinitive=abolir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[246] VerbFormInfo(infinitive=abolir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[1543] VerbFormInfo(infinitive=aguar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[1545] VerbFormInfo(infinitive=aguar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[1547] VerbFormInfo(infinitive=aguar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[1548] VerbFormInfo(infinitive=aguar, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[1564] VerbFormInfo(infinitive=aguentar, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[4309] VerbFormInfo(infinitive=averiguar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[4311] VerbFormInfo(infinitive=averiguar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[4313] VerbFormInfo(infinitive=averiguar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[4314] VerbFormInfo(infinitive=averiguar, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[4603] VerbFormInfo(infinitive=barrir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[4604] VerbFormInfo(infinitive=barrir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[4605] VerbFormInfo(infinitive=barrir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[4606] VerbFormInfo(infinitive=barrir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[4607] VerbFormInfo(infinitive=barrir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[4608] VerbFormInfo(infinitive=barrir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
6157] VerbFormInfo(infinitive=cobrir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[6158] VerbFormInfo(infinitive=cobrir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[6159] VerbFormInfo(infinitive=cobrir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[6160] VerbFormInfo(infinitive=cobrir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[6161] VerbFormInfo(infinitive=cobrir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[6162] VerbFormInfo(infinitive=cobrir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[6223] VerbFormInfo(infinitive=coibir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[6224] VerbFormInfo(infinitive=coibir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[6225] VerbFormInfo(infinitive=coibir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[6226] VerbFormInfo(infinitive=coibir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[6227] VerbFormInfo(infinitive=coibir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[6228] VerbFormInfo(infinitive=coibir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[6355] VerbFormInfo(infinitive=colorir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[6356] VerbFormInfo(infinitive=colorir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[6357] VerbFormInfo(infinitive=colorir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[6358] VerbFormInfo(infinitive=colorir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[6359] VerbFormInfo(infinitive=colorir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[6360] VerbFormInfo(infinitive=colorir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[7303] VerbFormInfo(infinitive=convelir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[7304] VerbFormInfo(infinitive=convelir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[7305] VerbFormInfo(infinitive=convelir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[7306] VerbFormInfo(infinitive=convelir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[7307] VerbFormInfo(infinitive=convelir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[7308] VerbFormInfo(infinitive=convelir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8275] VerbFormInfo(infinitive=delir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8276] VerbFormInfo(infinitive=delir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8277] VerbFormInfo(infinitive=delir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8278] VerbFormInfo(infinitive=delir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8279] VerbFormInfo(infinitive=delir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8280] VerbFormInfo(infinitive=delir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8317] VerbFormInfo(infinitive=demolir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8318] VerbFormInfo(infinitive=demolir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8319] VerbFormInfo(infinitive=demolir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8320] VerbFormInfo(infinitive=demolir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8321] VerbFormInfo(infinitive=demolir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8322] VerbFormInfo(infinitive=demolir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8959] VerbFormInfo(infinitive=descobrir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8960] VerbFormInfo(infinitive=descobrir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8961] VerbFormInfo(infinitive=descobrir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8962] VerbFormInfo(infinitive=descobrir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8963] VerbFormInfo(infinitive=descobrir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8964] VerbFormInfo(infinitive=descobrir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8983] VerbFormInfo(infinitive=descolorir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8984] VerbFormInfo(infinitive=descolorir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8985] VerbFormInfo(infinitive=descolorir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8986] VerbFormInfo(infinitive=descolorir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[8987] VerbFormInfo(infinitive=descolorir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[8988] VerbFormInfo(infinitive=descolorir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[9158] VerbFormInfo(infinitive=desdar, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[9877] VerbFormInfo(infinitive=despir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[9878] VerbFormInfo(infinitive=despir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[9879] VerbFormInfo(infinitive=despir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[9880] VerbFormInfo(infinitive=despir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[9881] VerbFormInfo(infinitive=despir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[9882] VerbFormInfo(infinitive=despir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[10315] VerbFormInfo(infinitive=digerir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[10316] VerbFormInfo(infinitive=digerir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[10317] VerbFormInfo(infinitive=digerir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[10318] VerbFormInfo(infinitive=digerir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[10319] VerbFormInfo(infinitive=digerir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[10320] VerbFormInfo(infinitive=digerir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[10423] VerbFormInfo(infinitive=discernir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[10424] VerbFormInfo(infinitive=discernir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[10425] VerbFormInfo(infinitive=discernir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[10426] VerbFormInfo(infinitive=discernir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[10427] VerbFormInfo(infinitive=discernir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[10428] VerbFormInfo(infinitive=discernir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[10561] VerbFormInfo(infinitive=distinguir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[10562] VerbFormInfo(infinitive=distinguir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[10563] VerbFormInfo(infinitive=distinguir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[10564] VerbFormInfo(infinitive=distinguir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[10565] VerbFormInfo(infinitive=distinguir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[10566] VerbFormInfo(infinitive=distinguir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[11329] VerbFormInfo(infinitive=empedernir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[11330] VerbFormInfo(infinitive=empedernir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[11331] VerbFormInfo(infinitive=empedernir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[11332] VerbFormInfo(infinitive=empedernir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[11333] VerbFormInfo(infinitive=empedernir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[11334] VerbFormInfo(infinitive=empedernir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[11536] VerbFormInfo(infinitive=encalçar, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[11707] VerbFormInfo(infinitive=encobrir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[11708] VerbFormInfo(infinitive=encobrir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[11709] VerbFormInfo(infinitive=encobrir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[11710] VerbFormInfo(infinitive=encobrir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[11711] VerbFormInfo(infinitive=encobrir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[11712] VerbFormInfo(infinitive=encobrir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[12103] VerbFormInfo(infinitive=engolir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[12104] VerbFormInfo(infinitive=engolir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[12105] VerbFormInfo(infinitive=engolir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[12106] VerbFormInfo(infinitive=engolir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[12107] VerbFormInfo(infinitive=engolir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[12108] VerbFormInfo(infinitive=engolir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[12613] VerbFormInfo(infinitive=enxaguar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[12615] VerbFormInfo(infinitive=enxaguar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[12617] VerbFormInfo(infinitive=enxaguar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[12618] VerbFormInfo(infinitive=enxaguar, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[13891] VerbFormInfo(infinitive=esvair, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[13892] VerbFormInfo(infinitive=esvair, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[13893] VerbFormInfo(infinitive=esvair, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[13894] VerbFormInfo(infinitive=esvair, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[13895] VerbFormInfo(infinitive=esvair, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[13896] VerbFormInfo(infinitive=esvair, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[13915] VerbFormInfo(infinitive=europeizar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[13917] VerbFormInfo(infinitive=europeizar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[13919] VerbFormInfo(infinitive=europeizar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[13920] VerbFormInfo(infinitive=europeizar, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14245] VerbFormInfo(infinitive=explodir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14246] VerbFormInfo(infinitive=explodir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14247] VerbFormInfo(infinitive=explodir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14248] VerbFormInfo(infinitive=explodir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14249] VerbFormInfo(infinitive=explodir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14250] VerbFormInfo(infinitive=explodir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14353] VerbFormInfo(infinitive=extinguir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14354] VerbFormInfo(infinitive=extinguir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14355] VerbFormInfo(infinitive=extinguir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14356] VerbFormInfo(infinitive=extinguir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14357] VerbFormInfo(infinitive=extinguir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14358] VerbFormInfo(infinitive=extinguir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14485] VerbFormInfo(infinitive=falir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14486] VerbFormInfo(infinitive=falir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14487] VerbFormInfo(infinitive=falir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14488] VerbFormInfo(infinitive=falir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14489] VerbFormInfo(infinitive=falir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14490] VerbFormInfo(infinitive=falir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14899] VerbFormInfo(infinitive=florir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14900] VerbFormInfo(infinitive=florir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14901] VerbFormInfo(infinitive=florir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14902] VerbFormInfo(infinitive=florir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[14903] VerbFormInfo(infinitive=florir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[14904] VerbFormInfo(infinitive=florir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[15427] VerbFormInfo(infinitive=ganir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[15428] VerbFormInfo(infinitive=ganir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[15429] VerbFormInfo(infinitive=ganir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[15430] VerbFormInfo(infinitive=ganir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[15431] VerbFormInfo(infinitive=ganir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[15432] VerbFormInfo(infinitive=ganir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[15503] VerbFormInfo(infinitive=gear, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[15931] VerbFormInfo(infinitive=hastear, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[15933] VerbFormInfo(infinitive=hastear, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[15935] VerbFormInfo(infinitive=hastear, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[15936] VerbFormInfo(infinitive=hastear, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[17539] VerbFormInfo(infinitive=latir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[17540] VerbFormInfo(infinitive=latir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[17541] VerbFormInfo(infinitive=latir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[17542] VerbFormInfo(infinitive=latir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[17543] VerbFormInfo(infinitive=latir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[17544] VerbFormInfo(infinitive=latir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[17827] VerbFormInfo(infinitive=louquear, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[17829] VerbFormInfo(infinitive=louquear, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[17831] VerbFormInfo(infinitive=louquear, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[17832] VerbFormInfo(infinitive=louquear, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[18001] VerbFormInfo(infinitive=malquerer, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18002] VerbFormInfo(infinitive=malquerer, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[18003] VerbFormInfo(infinitive=malquerer, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18004] VerbFormInfo(infinitive=malquerer, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[18005] VerbFormInfo(infinitive=malquerer, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18006] VerbFormInfo(infinitive=malquerer, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[18115] VerbFormInfo(infinitive=manutenir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18116] VerbFormInfo(infinitive=manutenir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[18117] VerbFormInfo(infinitive=manutenir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18118] VerbFormInfo(infinitive=manutenir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[18119] VerbFormInfo(infinitive=manutenir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18120] VerbFormInfo(infinitive=manutenir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[18553] VerbFormInfo(infinitive=minguar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18555] VerbFormInfo(infinitive=minguar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18557] VerbFormInfo(infinitive=minguar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18558] VerbFormInfo(infinitive=minguar, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[18637] VerbFormInfo(infinitive=mobiliar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18639] VerbFormInfo(infinitive=mobiliar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18641] VerbFormInfo(infinitive=mobiliar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18793] VerbFormInfo(infinitive=mosquear, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18795] VerbFormInfo(infinitive=mosquear, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18797] VerbFormInfo(infinitive=mosquear, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18798] VerbFormInfo(infinitive=mosquear, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[18985] VerbFormInfo(infinitive=negociar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18987] VerbFormInfo(infinitive=negociar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18989] VerbFormInfo(infinitive=negociar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[18990] VerbFormInfo(infinitive=negociar, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[19789] VerbFormInfo(infinitive=parir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[19790] VerbFormInfo(infinitive=parir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[19791] VerbFormInfo(infinitive=parir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[19792] VerbFormInfo(infinitive=parir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[19793] VerbFormInfo(infinitive=parir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[19794] VerbFormInfo(infinitive=parir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[20575] VerbFormInfo(infinitive=polir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[20576] VerbFormInfo(infinitive=polir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[20577] VerbFormInfo(infinitive=polir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[20578] VerbFormInfo(infinitive=polir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[20579] VerbFormInfo(infinitive=polir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[20580] VerbFormInfo(infinitive=polir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[20851] VerbFormInfo(infinitive=premiar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[20853] VerbFormInfo(infinitive=premiar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[20855] VerbFormInfo(infinitive=premiar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[20856] VerbFormInfo(infinitive=premiar, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[20857] VerbFormInfo(infinitive=premir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[20858] VerbFormInfo(infinitive=premir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[20859] VerbFormInfo(infinitive=premir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[20860] VerbFormInfo(infinitive=premir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[20861] VerbFormInfo(infinitive=premir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[20862] VerbFormInfo(infinitive=premir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[21139] VerbFormInfo(infinitive=proibir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[21140] VerbFormInfo(infinitive=proibir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[21141] VerbFormInfo(infinitive=proibir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[21142] VerbFormInfo(infinitive=proibir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[21143] VerbFormInfo(infinitive=proibir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[21144] VerbFormInfo(infinitive=proibir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22009] VerbFormInfo(infinitive=recobrir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22010] VerbFormInfo(infinitive=recobrir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22011] VerbFormInfo(infinitive=recobrir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22012] VerbFormInfo(infinitive=recobrir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22013] VerbFormInfo(infinitive=recobrir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22014] VerbFormInfo(infinitive=recobrir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22207] VerbFormInfo(infinitive=redescobrir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22208] VerbFormInfo(infinitive=redescobrir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22209] VerbFormInfo(infinitive=redescobrir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22210] VerbFormInfo(infinitive=redescobrir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22211] VerbFormInfo(infinitive=redescobrir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22212] VerbFormInfo(infinitive=redescobrir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22687] VerbFormInfo(infinitive=remir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22688] VerbFormInfo(infinitive=remir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22689] VerbFormInfo(infinitive=remir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22690] VerbFormInfo(infinitive=remir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22691] VerbFormInfo(infinitive=remir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22692] VerbFormInfo(infinitive=remir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22759] VerbFormInfo(infinitive=renhir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22760] VerbFormInfo(infinitive=renhir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22761] VerbFormInfo(infinitive=renhir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22762] VerbFormInfo(infinitive=renhir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22763] VerbFormInfo(infinitive=renhir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22764] VerbFormInfo(infinitive=renhir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22867] VerbFormInfo(infinitive=repolir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22868] VerbFormInfo(infinitive=repolir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22869] VerbFormInfo(infinitive=repolir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22870] VerbFormInfo(infinitive=repolir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22871] VerbFormInfo(infinitive=repolir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[22872] VerbFormInfo(infinitive=repolir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[22975] VerbFormInfo(infinitive=requerer, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23029] VerbFormInfo(infinitive=resfolegar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23031] VerbFormInfo(infinitive=resfolegar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23033] VerbFormInfo(infinitive=resfolegar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23034] VerbFormInfo(infinitive=resfolegar, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[23347] VerbFormInfo(infinitive=reunir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23348] VerbFormInfo(infinitive=reunir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[23349] VerbFormInfo(infinitive=reunir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23350] VerbFormInfo(infinitive=reunir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[23351] VerbFormInfo(infinitive=reunir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23352] VerbFormInfo(infinitive=reunir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[23635] VerbFormInfo(infinitive=ruir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23636] VerbFormInfo(infinitive=ruir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[23637] VerbFormInfo(infinitive=ruir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23638] VerbFormInfo(infinitive=ruir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[23639] VerbFormInfo(infinitive=ruir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23640] VerbFormInfo(infinitive=ruir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[23791] VerbFormInfo(infinitive=saltear, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23793] VerbFormInfo(infinitive=saltear, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23795] VerbFormInfo(infinitive=saltear, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23796] VerbFormInfo(infinitive=saltear, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[23893] VerbFormInfo(infinitive=saudar, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23895] VerbFormInfo(infinitive=saudar, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23897] VerbFormInfo(infinitive=saudar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[23898] VerbFormInfo(infinitive=saudar, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[25039] VerbFormInfo(infinitive=tactear, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25041] VerbFormInfo(infinitive=tactear, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25043] VerbFormInfo(infinitive=tactear, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25044] VerbFormInfo(infinitive=tactear, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[25271] VerbFormInfo(infinitive=terçar, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25375] VerbFormInfo(infinitive=tirotear, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25377] VerbFormInfo(infinitive=tirotear, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25379] VerbFormInfo(infinitive=tirotear, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25380] VerbFormInfo(infinitive=tirotear, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[25489] VerbFormInfo(infinitive=tossir, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25490] VerbFormInfo(infinitive=tossir, tense=SubjunctivePresentTense, person=FIRST, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[25491] VerbFormInfo(infinitive=tossir, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25492] VerbFormInfo(infinitive=tossir, tense=SubjunctivePresentTense, person=SECOND, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[25493] VerbFormInfo(infinitive=tossir, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[25494] VerbFormInfo(infinitive=tossir, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
[26755] VerbFormInfo(infinitive=voltear, tense=SubjunctivePresentTense, person=FIRST, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[26757] VerbFormInfo(infinitive=voltear, tense=SubjunctivePresentTense, person=SECOND, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[26759] VerbFormInfo(infinitive=voltear, tense=SubjunctivePresentTense, person=THIRD, number=SINGULAR, gender=UNDEFINED, voice=ACTIVE)
[26760] VerbFormInfo(infinitive=voltear, tense=SubjunctivePresentTense, person=THIRD, number=PLURAL, gender=UNDEFINED, voice=ACTIVE)
different base for resfolegar

what to do with gear - doesn't has form
* */
object SubjunctivePresentTenseConjugator : SubjunctiveMoodTenseConjugator, FiniteTenseConjugator() {
    override val arSuffix = SuffixGroup("e", "es", "e", "emos", "eis", "em")
    override val erSuffix = SuffixGroup("a", "as", "a", "amos", "ais", "am")
    override val irSuffix = erSuffix //it is exactly the same

    override val irregularForms: Map<String, IrregularForm> = mapOf(
//        Pair(IrregularVerbs.or.POR, IrregularForm(suffixGroup = erSuffix)),

        Pair(IrregularVerbs.ar.ESTAR, IrregularForm(base = "estej", suffixGroup = erSuffix)),
        Pair(IrregularVerbs.ar.DAR, IrregularForm(FormGroup("dê", "dês", "dê", "demos", "deis", "deem"))),

        Pair(IrregularVerbs.er.SER, IrregularForm(base = "sej")),
//        Pair(IrregularVerbs.er.TER, IrregularForm(base="tenh")),
        Pair(IrregularVerbs.er.HAVER, IrregularForm(base = "haj")), //but it is defective too
//        Pair(IrregularVerbs.er.FAZER, IrregularForm(base="faç")),
//        Pair(IrregularVerbs.er.DIZER, IrregularForm(base="dig")),
//        Pair(IrregularVerbs.er.PODER, IrregularForm(base="poss")),
//        Pair(IrregularVerbs.er.VER, IrregularForm(base = "vej")),
        Pair(IrregularVerbs.er.SABER, IrregularForm(base = "saib")),
        Pair(IrregularVerbs.er.QUERER, IrregularForm(base = "queir")),
//
//        Pair(IrregularVerbs.er.LER, IrregularForm(base="lei")),
//        Pair(IrregularVerbs.er.TRAZER, IrregularForm(base="trag")),
//        Pair(IrregularVerbs.er.PERDER, IrregularForm(base = "perc")),
//        Pair(IrregularVerbs.er.CABER, IrregularForm(base = "caib")),
//        Pair(IrregularVerbs.er.PROVER, IrregularForm(base = "provej")),
//        Pair(IrregularVerbs.er.CRER, IrregularForm(base = "crei")),
//        Pair(IrregularVerbs.er.REQUERER, IrregularForm(base = "requeir")),
//        Pair(IrregularVerbs.er.VALER, IrregularForm(base = "valh")),
//        Pair(IrregularVerbs.er.ERGUER, IrregularForm(base = "erg")),
//
//        Pair(IrregularVerbs.ir.VIR, IrregularForm(base = "venh")),
//        Pair(IrregularVerbs.ir.OUVIR, IrregularForm(base = "ouço")),
//        Pair(IrregularVerbs.ir.PEDIR, IrregularForm(base = "peço")),
        Pair(IrregularVerbs.ir.IR, IrregularForm(FormGroup("vá", "vás", "vá", "vamos", "vades", "vão"))),
//        Pair(IrregularVerbs.ir.DORMIR, IrregularForm(base="durm")),
//        Pair(IrregularVerbs.ir.RIR, IrregularForm(base = "ri")),
    )

    override val currentDefectiveGroups: Map<DefectiveGroup, List<String>>
        get() = mapOf(
            Pair(
                DefectiveGroup(false, false, false, false, false, false),
                listOf(
                    DefectiveVerbs.ABOLIR,
                    DefectiveVerbs.BARRIR,
                    DefectiveVerbs.COLORIR,
                    DefectiveVerbs.DELIR,
                    DefectiveVerbs.DEMOLIR,
                    DefectiveVerbs.DESCOLORIR,
                    DefectiveVerbs.EXPLODIR,
                    DefectiveVerbs.FALIR,
                    DefectiveVerbs.FLORIR,
                    DefectiveVerbs.GANIR,
                    DefectiveVerbs.LATIR,
                    DefectiveVerbs.REMIR,
                    DefectiveVerbs.RUIR,
                )
            )
        )

    override val specialVerbBaseByTense = FirstSingularIndicativePresentSpecialVerbBase

//    object UZIR_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.UZIR
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            regularSuffix.copy(singularThird = "") //finishes with -z
//    }
//
//    object AZER_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.AZER
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            regularSuffix.copy(singularThird = "") //finishes with -z
//    }
//
//    object AIR_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.AIR
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            SuffixGroup("io", "is", "i", "ímos", "ís", regularSuffix.pluralThird)
//    }
//
//    object UIR_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.UIR
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            SuffixGroup(regularSuffix.singularFirst, "is", "i", "ímos", "ís", regularSuffix.pluralThird)
//    }

    object EAR_Suffix_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.EAR
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(
                "ie", "ies", "ie", regularSuffix.pluralFirst, regularSuffix.pluralSecond, "iem",
                droppingSuffixLength = 3 //need to take 3, because of base we take from inticative present
            )
    }

    //we need to take four letters
    //works only for fixed list of verbs MARIO - first letters of verbs
    object IAR_Suffix_MARIO_Rule : SpecialEndingSuffixRule {
        override val wordEnding = VerbEnds.IAR
        override val fixedVerbList = listOf("mediar", "ansiar", "remediar", "incendiar", "odiar",
            "intermediar" // additional
        )
        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
            SuffixGroup(
                "eie", "eies", "eie", "iemos", "ieis", "eiem",
                droppingSuffixLength = 4
            )
    }
//
//    //we need to take three letters
//    object OER_Suffix_Rule : SpecialEndingSuffixRule {
//        override val wordEnding = VerbEnds.OER
//        override fun getSuffix(verb: String, regularSuffix: SuffixGroup) =
//            regularSuffix.extendChar('o').copy(singularSecond = "óis", singularThird = "ói")
//    }

    override val specialEndingSuffixRules: List<SpecialEndingSuffixRule> = listOf(
//        UZIR_Suffix_Rule,
//        AZER_Suffix_Rule,
//        AIR_Suffix_Rule,
//        UIR_Suffix_Rule,
        EAR_Suffix_Rule,
        IAR_Suffix_MARIO_Rule,
//        OER_Suffix_Rule
    )

    object C_TO_QU_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = true
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            VerbHelper.replaceIfNecessaryC_LetterForQU_FragmentOrNull(verb)
    }

    object G_TO_GU_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = true
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            VerbHelper.replaceIfNecessaryG_LetterForGU_FragmentOrNull(verb)
    }

    object C_Cedilla_TO_C_Rule : BaseChangingRule {
        override fun isCorrectForm(verbArgs: VerbArguments): Boolean = true
        override fun changeBaseIfPossible(verb: String, exactSuffix: String, verbArgs: VerbArguments): String? =
            VerbHelper.replaceIfNecessaryC_Cedilla_LetterForC_LetterOrNull(verb)
    }

    //already for changed verbs
    override val baseChangingRules = listOf(
        C_TO_QU_Rule,
        G_TO_GU_Rule,
        C_Cedilla_TO_C_Rule
    )

    override fun toString(): String {
        return "SubjunctivePresentTenseConjugator"
    }
}