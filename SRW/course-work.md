---
## Front matter
title: "Research work"
subtitle: "Named Entity Recognition"
author: "Artamonov Timofey Evgenievich"

## Generic otions
lang: ru-RU
toc-title: "Table of contents"

## Bibliography
bibliography: bib/cite.bib
csl: pandoc/csl/gost-r-7-0-5-2008-numeric.csl

## Pdf output format
toc: true # Table of contents
toc-depth: 2
lof: true # List of figures
lot: true # List of tables
fontsize: 12pt
linestretch: 1.5
papersize: a4
documentclass: scrreprt
## I18n polyglossia
polyglossia-lang:
  name: english
  options:
	- spelling=modern
	- babelshorthands=true
polyglossia-otherlangs:
  name: russian
## I18n babel
babel-lang: english
babel-otherlangs: russian
## Fonts
mainfont: PT Serif
romanfont: PT Serif
sansfont: PT Sans
monofont: PT Mono
mainfontoptions: Ligatures=TeX
romanfontoptions: Ligatures=TeX
sansfontoptions: Ligatures=TeX,Scale=MatchLowercase
monofontoptions: Scale=MatchLowercase,Scale=0.9
## Biblatex
biblatex: true
biblio-style: "gost-numeric"
biblatexoptions:
  - parentracker=true
  - backend=biber
  - hyperref=auto
  - language=auto
  - autolang=other*
  - citestyle=gost-numeric
## Pandoc-crossref LaTeX customization
figureTitle: "Fig."
tableTitle: "Table"
listingTitle: "Listing"
lofTitle: "List of illustration"
lotTitle: "List of tables"
lolTitle: "Listing"
## Misc options
indent: true
header-includes:
  - \usepackage{indentfirst}
  - \usepackage{float} # keep figures where there are in the text
  - \floatplacement{figure}{H} # keep figures where there are in the text
---

# Introduction

Text analysis is quite a labor-intensive task, especially nowadays when it can involve entire databases with hundreds of thousands of lines of text. Extracting information from such text can take a considerable amount of time and effort from individuals involved in the task. Yet, the task of extracting information from text and analyzing it is becoming increasingly important for decision-making in various fields, including business and equally important areas like medicine.

To tackle such tasks, Natural Language Processing (NLP) technologies are employed. One of the key tasks in NLP is Named Entity Recognition (NER). Named Entity Recognition is the task of identifying and classifying named entities from text. The main entities include people's names, geographical and political locations, and organizations. This approach allows for the automatic extraction of important information from unstructured text, which can then be used for various purposes, such as database creation or automation of various text-related processes.

Neural networks are the primary tool for solving the named entity recognition task. These networks are pre-trained on large volumes of data and are capable of accurately predicting the correct entity tag.

The goal of this work is to learn how to utilize such models, train and fine-tune pre-trained models, and also explore text vectorization methods.

# Main part

## Part 1

## Part 2

## Part 3

# Conclusion
