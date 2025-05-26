# Flood Fill

Este projeto implementa o algoritmo **Flood Fill** em Java, com uma visualização gráfica usando a biblioteca **Swing**. Ou seja, você pode ver o preenchimento acontecendo em tempo real, pixel por pixel.

De forma resumida, o algoritmo percorre uma matriz de pixels e preenche áreas conectadas a partir de um ponto inicial, como um "balde de tinta" em editores de imagem.

> 📚 O projeto foi desenvolvido para a disciplina de **Estrutura de Dados**, portanto, as estruturas utilizadas - pilha (stack) e fila (queue) - foram criadas do zero.

## Funcionalidades
Isso é um programa de linha de comando, então é necessário executar o Main.java e seguir as instruções de input para seu funcionamento.

O programa oferece as seguintes operações:

1. **Tipo de Flood Fill**: Disponibilidade de algoritmo por Stack e Queue.
2. **Input**: Leitura de imagens `PNG`.
3. **Output**: As imagens processadas são escritas sob `PNG` na pasta `assets`.
4. **Visualização gráfica**: O Swing computa graficamente a pintura da imagem em tempo real.

## Estrutura de código
### Função de tolerância de cores
A fim de não ignorar pixels com cores ligeiramente diferentes da cor-alvo para pintura, foi desenvolvido um algoritmo bit-wise de tolerância RGB. Nessa função, é calculadA a diferença RGB absoluta entre duas cores e, se essa diferença for menor que a tolerância estabelecida, o pixel é pintado.

```java
private boolean isColorSimilar(int color1, int color2, int tolerance) {
    // Bitwise, compara a diferença absoluta entre dois valores RGB
    int r1 = (color1 >> 16) & 0xFF;
    int g1 = (color1 >> 8) & 0xFF;
    int b1 = color1 & 0xFF;

    int r2 = (color2 >> 16) & 0xFF;
    int g2 = (color2 >> 8) & 0xFF;
    int b2 = color2 & 0xFF;

    int difR = Math.abs(r1 - r2);
    int difG = Math.abs(g1 - g2);
    int difB = Math.abs(b1 - b2);

    return (difR + difG + difB) > tolerance;
}
```

A tolerância pode ser ajustada manualmente nas funções de Fill (Stack e Queue) na seguinte linha - no lugar do 30:
```java
  if (x < 0 || x >= m || y < 0 || y >= n || isColorSimilar(image.getRGB(x, y), oldColor, 30)) {
      continue;
  }
```

### Ponto inicial de pintura
As coordenadas iniciais do Fill podem ser alteradas manualmente no instanciamento do objeto FloodFill em `Main.java`.

```java
FloodFill f = new FloodFill(image, imagePanel, 100, 100);
```

### Leitura de imagem
Da mesma forma, a imagem a ser processada pode ser alterada na seguinte linha em `Main.java`:
```java
BufferedImage image = ImageIO.read(new File("assets/sample.png"));
```
