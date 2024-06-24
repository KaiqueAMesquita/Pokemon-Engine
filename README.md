# Pokemon-Engine

## Uso
- É necessário ter o Java instalado, juntamente com o **JDK (Java Development Kit)**, além de uma IDE que suporte Java para iniciar a edição e uso do projeto.
- Versão do Java utilizada: **21.0.2**
## Sobre o projeto
Comecei com a ideia de me desafiar e melhorar minhas habilidades em lógica e Java, e para isso nada melhor do que usar Pokémon, um dos meus jogos favoritos. A ideia é criar um programa que simule batalhas Pokémon exatamente como no jogo.😀

### Funcionalidades adicionadas
- Sistema de tipos;
- Sistema de efetividade de ataque;
- Sistema de batalha e ataques;
- Sistema de coleta de Pokemons com leitura de arquivo txt:
- Ex.:
  **Para adicionar Pokémon, siga o modelo no arquivo assets/pokedex.txt**

  ```txt
  #-------#
  nome: Bulbasaur
  tipoP: GRASS, POISON
  vida: 45
  speed: 45
  attack: 45
  spdAttack: 65
  defense: 49
  spdDefense: 65
  levelType: MEDIUM_SLOW
  #-------#
  
- Sistema de cálculo de XP/Nível do Pokémon;
- Sistema de cálculo de Status do Pokémon;
- Batalha JOptionPane;
- Sistema de EV/IV (afetando somente na função de status, valor manual) - incompleto;
  
### Funcionalidades pretendidas
- Geração de ataques por txt;
- Adição de ataques específicos para cada Pokémon (função *learningAttack()* ataques para aprender já criados);
- Sistema de ganho de XP(após vitória);
- Sistema de EV/IV completo;
- Mais fatores afetando o dano (tipo do Pokémon, clima, etc.);
- Sistema de party (equipe);
- Sistema de itens de batalha;
- Interface Gráfica;
