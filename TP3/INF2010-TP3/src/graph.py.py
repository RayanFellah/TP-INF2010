import matplotlib.pyplot as plt
import numpy as np


def plotLeGraph(arrays, avlCtr, bstCtr, type):
    plt.title(f'Comparaison des compteurs de type {type} des arbres')
    plt.xlabel("taille des arrays")
    plt.ylabel("valeurs des compteurs")
    plt.plot(arrays, avlCtr, color='r', label='AVL')
    plt.plot(arrays, bstCtr, color='b', label='BST')
    plt.legend()
    plt.show()





if __name__ == "__main__":
    arraySizes = [0, 10, 100, 1000]
    AVLInsert = [0, 66, 1314, 19770]
    BSTInsert = [0, 36, 755, 11117]
    AVLSearch = [0, 2, 6, 7]
    BSTSearch = [0, 4, 11, 8]

    plotLeGraph(arraySizes, AVLSearch, BSTSearch, "recherche")


