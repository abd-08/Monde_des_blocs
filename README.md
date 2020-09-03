# Monde_des_blocs

Nous travaillerons sur la modélisation d'un système communément appelé "monde des
blocs". Dans ce monde, l'utilisateur peut piloter un bras articulé (un robot) capable de
manipuler des cubes (les blocs) de taille et de couleur variables et de les empiler pour
construire des piles de cubes disposées sur une table. Le robot répond aux ordres de celui
qui le pilote, ordres exprimés par le biais de phrases courtes qu'il est capable de
comprendre, du genre "prends le grand cube bleu".


![Démonstration ](demo.gif)

## Description du diagramme des use-cases

![image diagramme use case](Use_Case_diagram.png)



Dans notre diagramme de use case notre operateur peut créer un cube, poser un cube, prendre un cube et
détruire un cube.

### **Créer cube :** 
* Pour créer un cube, il suffit d’avoir le robot de vide.
### **Poser cube :**
Poser un cube donne 2 possibilités,
 * **Poser sur la table :**
Pour poser un cube sur la table, il faut vérifier que notre robot tient un cube et que la table ai
assez de place pour déposer un cube par-dessus.
 * **Poser sur un cube :** 
Pour poser un cube sur la table, il faut vérifier que notre robot tient un cube et que le cube
sur lequel on pose notre cube existe.
### **Prendre cube :**
  Pour prendre un cube de la table, il faut vérifier que notre robot est vide et que le cube qu’on
recherche est présent sur la table.
### **Détruire cube :** 
  Pour détruire un cube faut vérifier que notre robot tient un cube.
  
  
  ## Le diagramme de classe
  
  ![image diagramme de classe](Class_diagram.png)
  
  Ci-dessous sera notre diagramme d’objet de base sur lequel nous allons travailler. Dans notre monde des
blocks nous avons besoin :
* **d’un objet table :** c ‘est le support des cubes
Une table est un objet qui possède des piles de cubes. Une table connaît que la base d’une
pile.
* **d’un objet cube :** c ‘est l'objet qu’on manipule
Un cube est un objet qui a une couleur et une taille. Un cube est soit sur une table, sur un
autre cube ou dans le robot. Un cube peut avoir un autre cube au-dessus de lui. Pour chaque cube on
aura un sommet.
* **d’un objet robot :** c’est ce qui va nous permettre de manipuler un cube
Un robot est un objet qui peut tenir un cube. Plusieurs fonctionnalités lui sont propre
comme créer un cube, détruire un cube, déposer un cube et prendre un cube.
* **d’un monde :** c’est ce qui nous permet de contenir les objets cubes, la table et le robot
