# Structure et Composition : Ed en autonome

Autour des expressions mathématique simple, pour montrer les design pattern 
* Composite,
* Visiteur,
* Template,
* Strategie,
* Interpreteur,
* Factory

## La grammaire simplifiée

* **MAJUSCULE GRAS** : non terminal sera modélisé par une Classe
* **minuscule gras** : un presque terminal (par exemple operation qui est en fait une des string +, - , ...) qui est un non Terminal mais nous le considérerons dans notre exemple comme un caractère spécial pouvant prendre une valeurs parmi plusieurs.
* minuscule : terminal exemple nombre, symbole, caractère spécial, ...

1. **EXPRESSION** ::= **CONST** | **ExpressionB**
2. **CONST** ::= nombre entier
3. **op** ::= + | - | * | /
4. **ExpressionB** ::= (**EXPRESSION** **op** **EXPRESSION**)

ou (à la place de 3, 4)

3. **ExpressionB** ::= ( **ADD** | **SOUS** | **MULT** | **DIV** )
4. **ADD**         ::= **EXPRESSION** + **EXPRESSION**
5. **SOUS**        ::= **EXPRESSION** - **EXPRESSION**
6. **MULT**        ::= **EXPRESSION** * **EXPRESSION**
7. **DIV**         ::= **EXPRESSION** / **EXPRESSION**

#  La version V0.1, composition, pattern composite, factory method, Template method 


## Pour voir la première version V0.1 

1. Faire clone du projet
2. Après le clone git checkout V0.1 (attention V0.1 n'est pas une branche mais un commit historique)
3. Ouvrir dans bluej le projet se trouvant `dans le repertoire <racine>/ExpMath/src/main/java

## Quelques règles
### Une règles de ce genre Non terminaux droite et gauche un | entre nom terminaux 

**NONTERMINALGAUCHE** ::= **NTDROIT<sub>1</sub>** | **NTDROIT<sub>2</sub>** | ... | **NTDROIT<sub>i</sub>**

Est traduit avec le **design pattern composite** ainsi

![Pattern compose](img/difinitionHeritage.png)

### Une règles de ce genre Non terminaux droite et à gauche des terminaux et nom terminaux en séquence

> Les non terminaux disparaissent en principe, ne servent que pour aider la syntaxe. Nous verrons qu'il permettront de choisir quoi faire seront utile pour construire un arbre syntaxique abstrait ou traduire : design pattern factory et startegy

**ExpressionB** ::= (**EXPRESSION** **op** **EXPRESSION**)

On applique la composition (pas le design pattern mais la composition d'objets)

```java
class ExpressionB {
    Expression e1;
    Op op;
    Expression e2;

    //.....
}
```

==> Regardez ce que tout ceci donne en première version: ouvrir dans blueJ <racine>/ExpMath/src/main/java

# Quelques questions de réflexion:

1. Que représente la méthode dans les classes du genre? ```public static Type create(parametres) { ... }```

2. D'après vous pourquoi le constructeur est private?
3. A quoi sert de réécrire les méthodes equal() et hashcode() ?
4. qui crée l'expression suivante `(((3 -5) + 6) +8)` puis lui appliquer les 3 méthodes eval(), evalnum() et show()
5. Excrire les 2 classes qui manques Mult et Div

## La version v0.2 : pattern visiteur pour evalNum seul

## La version v0.3 : pattern visiteur + stratégie par injection de l'évaluateur

===
//TODO la prochaine fois 
1. Appliquer le  pattern visiteurs pour simplifier les différente évaluation
2. Appliquer un méthode inspiré de la descente récursive pour faire le parsing du langage Expression math et générer l'AST
3. Réfléchir aux différentes améliorations possible



