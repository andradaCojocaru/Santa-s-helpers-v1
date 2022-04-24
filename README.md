# Santa-s-helper-v1
# Andrada-Ioana Cojocaru

In implementarea acestei teme am gandit mai multe entitati ce se leaga intre
ele si anume:
- Child care salveaza informatiile unui copil
- Santa ce contine numarul de ani in care se lucreaza, budgetul, lista de
cadouri si cea de copii
- Gift ce are informatiile unui cadou
create cu ajutorul design patternului Builder

Pentru parsarea JSON m-am folosit de InputLoader pentru salvarea informatiilor
in clasele corespunzatoare. Pentru salvarea obiectelor am creat clasa Utils pe
care o folosesc pentru salvarea fiecarui camp.

Calculam averageScore folosind design patternul Strategy combinat cu Factory
pentru fiecare tip de copil:
- daca are mai putin de 5 ani va avea scor 10
- daca are intre 5 si 12 ani vom face media aritmetica a notelor
- daca are intre 12 si 18 ani vom calcula media ponderata
- daca are mai mult de 18 ani, vom pune scor 11, astfel incat sa stim ca acel
copil trebuie eliminat din lista

Dupa ce am aflat scorurile fiecaruia, putem calcula bugetul asociat fiecaruia,
ceea ce se intampla in DataInput.
Cadourile sunt puse apoi in array in functie de categorie (GiftCategory)
, iar mai apoi sortate (SetGifts). Alegem cadouri pentru fiecare copil in
functie de preferinte si buget (FindGifts).

Dupa ce se termina primul an, intervine si array-ul de annualChanges, pentru a
modifica bugetul, se adauga cadouri, se adauga copii sau chiar se modifica unele
caracteristici ale copiilor existenti (niceScore, giftPreferences)
Se itereaza anii copiilor si se fac modificarile pe care le-am precizat anterior
in cadrul clasei ChangesOverYears.
Se reiau pasii de mai sus pentru datele noi.
Folosim un copy constructor pentru a salva datele, ce ne ajuta ca in cazul unor noi
modificari, acestea sa nu se resimta asupra datelor vechi.

FEEDBACK:
- o tema mai bine organizata decat cea precedenta
- la partea de JSON am intampinat mai multe probleme, incercand sa recreez ce a fost
implementat la prima tema, dar se putea face mai simplu; o idee ar fi sa existe mai
multe informatii pe ocw cu privire la aceasta tema, deoarece cele prezentate erau
foarte succinte




