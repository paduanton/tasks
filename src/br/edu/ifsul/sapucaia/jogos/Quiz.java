package br.edu.ifsul.sapucaia.jogos;

import java.util.Scanner;
public class Quiz {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        byte i, resp = 0, disc = 0, loop = 0, cont = 0; short pontAtual = 0, pontAnterior;

        while(resp != 1 && resp != 2) {
            System.out.println("Quer saber como jogar o QUIZ?      (1 - SIM, 2 - NÃO)");
            resp = (byte) t.nextInt();
            if(resp == 1) {
                System.out.print("Primeiro você deve escolher a disciplina que deseja, depois responder 10 questões sobre ela.\n"
                        +"no final você poderá jogar novamente e comparar os resultados que você obteve a partir do seu pontAtual.\nBons estudos =D\n");
            } else if(resp != 2) {
                System.out.print("\nOPÇÃO INVÁLIDA\n");
            }
        }
        do {
            pontAnterior = pontAtual;
            pontAtual = 0;
            while(disc != 1 && disc != 2 && disc != 3) {
                System.out.println("\nEscolha a disciplina que deseja fazer o QUIZ:\n1 - Matemática\n2 - Filosofia\n3 - Sociologia");
                disc = (byte) t.nextInt();
                if(disc != 1 && disc != 2 && disc != 3) {
                    System.out.print("\nDISCIPLINA INVÁLIDA\n");
                }
            } if(disc == 1) {   // Matemática
                resp = 0;
                System.out.print("\nMATEMÁTICA\n");
                for(i = 1; i <= 2; i++) { // questão 1
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 1\n");
                    System.out.print("\nEm um hotel, são gastos 14m³ de água por semana.\nQuantos litros são gastos por dia?");
                    System.out.print("\n"
                            + "1. 2"
                            + "\n2. 20"
                            + "\n3. 200"
                            + "\n4. 2000"
                            + "\n5. 2010"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 4 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: O metro cúbico equivale a um quilolitro.\n");
                        } else if(resp == 4 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 4) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 2
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 2\n");
                    System.out.print("\nPeter foi ao supermercado e comprou: 2 kg de batata, 3 kg de feijão e 5 litros de refrigerante.\nOs seus respectivos preços são: batata - R$2,15; feijão - R$4,03 e refrigerante - R$2,48. Peter\npagou as compras com uma nota de R$50,00. O troco em reais que Peter recebeu foi de:");
                    System.out.print("\n"
                            + "1. R$21,21"
                            + "\n2. R$29,60"
                            + "\n3. R$21,48"
                            + "\n4. R$28,79"
                            + "\n5. R$20,40"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 1 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: Subtraia o valor total da compra da quantia que peter pagou.\n");
                        } else if(resp == 1 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 1) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 3
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 3\n");
                    System.out.print("\nEm 30 g de presunto há 8 g de proteínas, 240 mg de sódio, 6 g de gorduras totais e 0 g\nde fibra alimentar. Qual é a quantidade de proteínas, em quilos, ingerida através de uma\nporção de 75g de de presunto?");
                    System.out.print("\n"
                            + "1. 0,15"
                            + "\n2. 0,018"
                            + "\n3. 0,02"
                            + "\n4. 0,2"
                            + "\n5. 0,18"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 3 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: Para converter grama pra quilo use a fórmula: g/1000.\n");
                        } else if(resp == 3 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 4
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 4\n");
                    System.out.print("\nQual foi a primeira raiz quadrada irracional descoberta?");
                    System.out.print("\n"
                            + "1. 6"
                            + "\n2. 2"
                            + "\n3. 3"
                            + "\n4. 5"
                            + "\n5. 7"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 2 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: Foi descoberta por Pitágoras e seus seguidores.\n");
                        } else if(resp == 2 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 2) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 5
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 5\n");
                    System.out.print("\nPara revestir o chão de um quarto retangular de 4 m decomprimento e 3 m de largura,\nfoi utilizado piso cerâmico quadrado medindo 50 cm cada lado.\nConsiderando que não houve desperdícios, quantas peças do piso cerâmico foram gastas\nnesse revestimento?");
                    System.out.print("\n"
                            + "1. 24"
                            + "\n2. 12"
                            + "\n3. 60"
                            + "\n4. 48"
                            + "\n5. 7"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 4 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: Em 4 m cabem 8 peças e a cada 3 m cabem 6.\n");
                        } else if(resp == 4 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 4) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 6
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 6\n");
                    System.out.print("\nSeja a equação x² + 5x + 6 = 0, a soma de x¹ + x² é igual a:");
                    System.out.print("\n"
                            + "1. -5"
                            + "\n2. -2"
                            + "\n3. 5"
                            + "\n4. -3"
                            + "\n5. 4"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 1 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: Resolva pela fórmula de Bhaskara ou por fatoração.\n");
                        } else if(resp == 1 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 1) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 7
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 7\n");
                    System.out.print("\nUm sapato que custa R$ 80,00, com um desconto de 5%, passou a custar quanto?");
                    System.out.print("\n"
                            + "1. R$68,00"
                            + "\n2. R$72,00"
                            + "\n3. R$40,00"
                            + "\n4. R$76,00"
                            + "\n5. R$75,00"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 4 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: 5% equivale à 0,05.\n");
                        } else if(resp == 4 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 4) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 8
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 8\n");
                    System.out.print("\nPara a organização da tabela dos jogos da copa do mundo, os 48 países participantes foram\ndivididos em 8 grupos com a mesma quantidade de times. Cada grupo ficou com?");
                    System.out.print("\n"
                            + "1. 8 países"
                            + "\n2. 5 paíes"
                            + "\n3. 7 países"
                            + "\n4. 6 países"
                            + "\n5. 4 países"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 4 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: Use divisão para resvolver a questão.\n");
                        } else if(resp == 4 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 4) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 9
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 9\n");
                    System.out.print("\nTrês torneiras, com vazões iguais e constantes, enchem totalmente uma caixa d’água em 45 minutos.\nPara acelerar esse processo, duas novas torneiras, iguais às primeiras, foram instaladas. Assim,\no tempo gasto para encher essa caixa d’água foi reduzido em:");
                    System.out.print("\n"
                            + "1. 18 min"
                            + "\n2. 20 min"
                            + "\n3. 22 min"
                            + "\n4. 25 min"
                            + "\n5. 28 min"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 1 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: Use regra de três simples para fazer a questão.\n");
                        } else if(resp == 1 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 1) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 10
                    System.out.print("-----------------------------------------------------------------------------------\nQuestão 10\n");
                    System.out.print("\nEm uma prova discursiva de álgebra com apenas duas questões, 470 alunos acertaram\nsomente uma das questões e 260 acertaram a segunda. Sendo que 90 alunos acertaram\nas duas e 210 alunos erraram a primeira questão. Quantos alunos fizeram a prova?");
                    System.out.print("\n"
                            + "1. 470"
                            + "\n2. 710"
                            + "\n3. 600"
                            + "\n4. 560"
                            + "\n5. 300"
                            + "\nResposta: ");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 3 && i == 1) {
                            System.out.print("\nResposta errada.\nDica: Use conjuntos para resolver essa questão.\n");
                        } else if(resp == 3 && i == 1) {
                            pontAtual += 100;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.print("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.print("\n ------------\n| VOCÊ ERROU |\n ------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPONTUAÇÃO FINAL: "+pontAtual+"\n\n");
            } else if(disc == 2) {   // Filosofia
                resp = 0;
                System.out.print("\nFILOSOFIA\n");
                for(i = 1; i <= 2; i++) {  // questão 1
                    System.out.println("-----------------------------------------------------------------------------------\n1) O que é filosofia?");
                    System.out.println(""
                            + "1.  É o estudo dos pensamentos."
                            + "\n2.  Filosofia é a decisão de não aceitar as coisas pela aparência, mas poder questionar."
                            + "\n3.  Filosofia é aceitar o mundo como ele é."
                            + "\n4.  São fórmulas prontas que respondem qualquer pergunta."
                            + "\n5.  Filosofia significa estudar as perguntas, sem se preuocupar com as respostas");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 2 && i == 1) {
                            System.out.println("Resposta errada.\nDica: A filosofia busca questionar, nao aceitar.\n");
                        } else if(resp == 2 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 2) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 2
                    System.out.println("-----------------------------------------------------------------------------------\n2) Qual o significado da palavra filosofia?");
                    System.out.println("1.  Filosofia significa 'o estudo do saber'"
                            + "\n2.  Filosofia significa 'amar à Deus'. "
                            + "\n3.  Filosofia significa 'amor à sabedoria'.  "
                            + "\n4.  Filosofia significa 'O estudo do pensamento'."
                            + "\n5.  Nenhuma das anteriores.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 3 && i == 1) {
                            System.out.println("Resposta errada.\nDica:É uma frase grega.\n");
                        } else if(resp == 3 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------/n");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------/n");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 3
                    System.out.println("-----------------------------------------------------------------------------------\n3) Em relacao a frase anterior 'amor a sabedoria', qual foi o filósofo que a falou?");
                    System.out.println("1. Platão "
                            + "\n2.  Stirner, Max "
                            + "\n3.  Einstein, Albert"
                            + "\n4.  Pitágoras"
                            + "\n5.  Aristóteles");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 4 && i == 1) {
                            System.out.println("Resposta errada.\nDica:Foi um Grego que falou ;D\n");
                        } else if(resp == 4 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 4) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 4
                    System.out.println("-----------------------------------------------------------------------------------\n4) O que é senso comum??");
                    System.out.println("1.  O senso que todo ser humano tem por natureza."
                            + "\n2.  O sexto sentido que temos em comum. Tanto homens quanto mulheres."
                            + "\n3.  Um senso que apenas pessoas pobres têm. Por isso é comum."
                            + "\n4.  É o conhecimento transimito de geração em geração. Relacionado a mito e cranças."
                            + "\n5.  Nenhuma das anteriores.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 4 && i == 1) {
                            System.out.println("Resposta errada.\nDica: O que voce acredita nem sempre é a veredade. E você sequer se pergunta porque acredita.\n");
                        } else if(resp == 4 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 4) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 5
                    System.out.println("-----------------------------------------------------------------------------------\n5) Uma pessoa dogmática:");
                    System.out.println("1.  Do termo Inglês: que é fanática por cães(dog)."
                            + "\n2.  Não afirma nem crê que algo é verdadeiro e/ou indiscutível."
                            + "\n3.  Discute os inúmeros pontos de vista."
                            + "\n4.  Afirma ou crê em algo como verdadeiro mas discutível."
                            + "\n5.  Afirma ou crê em algo como verdadeiro e/ou indiscutível.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 5 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Dogma é um termo de origem grega que significa literalmente “o que se pensa é verdade”.\n");
                        } else if(resp == 5 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 5) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 6
                    System.out.println("-----------------------------------------------------------------------------------\n6) Sobre a religiao, podemos afirmar que:");
                    System.out.println("1.  É liberal e não segue dogmas."
                            + "\n2.  É dogmática e rígida."
                            + "\n3.  Está sempre encontrando novas teorias."
                            + "\n4.  Não é rídida nem dogmática."
                            + "\n5.  É dogmática porém aceita novas teorias regularmente.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 2 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Não mudou muito nas últimas décadas.\n");
                        } else if(resp == 2 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 2) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 7
                    System.out.println("-----------------------------------------------------------------------------------\n7) O que é anarquismo filosófico?");
                    System.out.println("1.  Sistema econômico baseado na legitimidade dos bens privados e na irrestrita liberdade de comércio e indústria, com o principal objetivo de adquirir lucro."
                            + "\n2.  Doutrina política e econômica que prega a coletivização dos meios de produção e de distribuição, mediante a supressão da propriedade privada e das classes sociais."
                            + "\n3.  Organização socioeconômica baseada na propriedade coletiva dos meios de produção."
                            + "\n4.  É um movimento que alega que o Governo não possui legitimidade moral e não defende uma revolução violenta para eliminá-lo, mas defende a evolução pacífica para superá-lo."
                            + "\n5.  É toda a forma de pensar, sentir e agir adotada pela sociedade e que ela considera certo, e existe um consenso coletivo sobre essa determinada idéia.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 4 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Anarquismo é contra o governo");
                        } else if(resp == 4 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 4) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 8
                    System.out.println("-----------------------------------------------------------------------------------\n8) Sobre o senso crítico, é INCORRETO afirmar que:");
                    System.out.println("1.  Se assemelha ao senso comum."
                            + "\n2.  Não se assemelha ao senso comum."
                            + "\n3.  Não aceita apenas uma informação como verdadeira."
                            + "\n4.  Está relacionada a capacidade de fazer julgamentos."
                            + "\n5.  Promove a capacidade de pensar sobre as verdades impostas pela sociedade");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 1 && i == 1) {
                            System.out.println("Resposta errada.\nDica: O senso crítico busca pensar de forma diferente do senso comum.\n");
                        } else if(resp == 1 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 1) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 9
                    System.out.println("-----------------------------------------------------------------------------------\n9) Todos são filósofos exceto:");
                    System.out.println("1.  Arquimedes"
                            + "\n2.  Spinoza, Baruch"
                            + "\n3.  Sócrates"
                            + "\n4.  Karl Max"
                            + "\n5.  Stephen Hawking");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 5 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Começa com 'S'.");
                        } else if(resp == 5 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 5) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;
                for(i = 1; i <= 2; i++) {  // questão 10
                    System.out.println("-----------------------------------------------------------------------------------\n10) A Lógica investiga a validade dos argumentos e dá as regras do pensamento correto. A cerca desta área da Filosofia, é CORRETO afirmar que: ");
                    System.out.println("1.  Se trata do estudo normativo das condições da verdade, ou seja, da conseqüência e da verdade da argumentação."
                            + "\n2.  Só teve reflexo na obra dos pensadores pré-socráticos."
                            + "\n3.  se limita a biologia."
                            + "\n4.  Encontra em Karl Marx um dos seus mais notórios teóricos."
                            + "\n5.  é o principal objeto das indagações sociologia.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 1 && i == 1) {
                            System.out.println("Resposta errada.\nDica: A lógica determina o que é verdadeiro ou não, ou seja, não existe incerteza quando usado a lógica.");
                        } else if(resp == 1 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 1) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPONTUAÇÃO FINAL: "+pontAtual+"\n\n");
            } else {        // Sociologia
                resp = 0;
                System.out.println("\nSOCIOLOGIA\n");
                for(i = 1; i <= 2; i++) {
                    System.out.println("Segundo Durkheim, o funcionalismo é...?");
                    System.out.println("1. Um conceito que defende todas as práticas pessoais.\n"
                            + "2. A forma com que os indivíduos interagem entre si.\n"
                            + "3. A interdependência de todos os elementos de um sistema social.\n"
                            + "4. A interdependência de certos elementos de um sistema social.\n"
                            + "5. A dependência de todo um sistema social em apenas uma pessoa.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 3 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Uns dependem dos outros.\n");
                        } else if(resp == 3 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;

                for(i = 1; i <= 2; i++) {
                    System.out.println("Entre os sociólogos que compõem a sociologia clássica, estão:");
                    System.out.println("1. Emile Durkheim e Max Weber\n"
                            + "2. Karl Marx e Mirian Goldenberg\n"
                            + "3. Paulo Freire e Vinicius Mayo\n"
                            + "4. Karl Marx e Sócrates\n"
                            + "5. Emile Durkheim e Platão");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 1 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Sócrates e Platão foram importantes filósofos da Antiguidade.\n");
                        } else if(resp == 1 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;

                for(i = 1; i <= 2; i++) {
                    System.out.println("Qual o significado do termo \"Etnia\"?");
                    System.out.println("1. É outra forma de distinguir \"raça\".\n"
                            + "2. É uma distinção sociocultural e histórica de grupos sociais.\n"
                            + "3. É uma distinção biológica de grupos sociais.\n"
                            + "4. É uma distinção sociocultural e histórica de raças.\n"
                            + "5. É considerar a própria raça superior às demais.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 2 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Raça é algo biológico, não sociológico.\n");
                        } else if(resp == 2 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;

                for(i = 1; i <= 2; i++) {
                    System.out.println("O Etnocentrismo (ethnos e centrismo) tem os seguintes significados:");
                    System.out.println("1. \"ethnos\" significa nação, tribo ou pessoas que vivem juntas e centrismo significa a igualdade da sociedade.\n"
                            + "2. \"ethnos\" significa a pessoa individual e centrismo significa o centro de tudo.\n"
                            + "3. \"ethnos\" significa nação, tribo ou pessoas que vivem juntas e centrismo que indica o centro de tudo.\n"
                            + "4. \"ethnos\" significa a pessoa individual e centrismo significa a pessoa individual.\n"
                            + "5.  \"ethnos\" significa nação, tribo ou pessoas que vivem juntas e centrismo significa \"Tudo aquilo que se vê\".");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 3 && i == 1) {
                            System.out.println("Resposta errada.\nDica: ethnos = etnia, centrismo = centro.\n");
                        } else if(resp == 3 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;

                for(i = 1; i <= 2; i++) {
                    System.out.println("Qual a percepção do senso comum?");
                    System.out.println("1. É uma percepção geralmente aprofundada, que tem seu real significado sempre reforçado.\n"
                            + "2. É uma percepção aprofundada, que é de conhecimento da maioria da sociedade.\n"
                            + "3. É uma percepção superficial, que é de conhecimento da maioria da sociedade e é levada como verídica.\n"
                            + "4. É uma percepção exata, mas não muito aprofundada, no qual a maioria da população desconhece.\n"
                            + "5. É uma percepção geralmente superficial, que sempre é falsa.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 3 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Senso comum = conhecimentos partilhados por todos.\n");
                        } else if(resp == 3 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;

                for(i = 1; i <= 2; i++) {
                    System.out.println("Seguindo a lógica do fato social, qual a alternativa incorreta?");
                    System.out.println("1. Fatos sociais são gerais pois devem ser cumpridos por todos.\n"
                            + "2. Fatos sociais são coercitivos pois não impõem penalidades àqueles que não cumprem as normas.\n"
                            + "3. Fatos sociais não são gerais pois devem ser cumpridos por todos.\n"
                            + "4. Fatos sociais são coercitivos pois impõem penalidades àqueles que não cumprem as suas normas.\n"
                            + "5. Fatos sociais são exteriores pois existem apenas com a sua vontade e reflexão.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 4 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Um ato geral é um ato que todos geralmente fazem. Externo é algo que não se tem nenhum contato.\n");
                        } else if(resp == 4 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;

                for(i = 1; i <= 2; i++) {
                    System.out.println("Qual o significado de anomia (do grego nómos)?");
                    System.out.println("1. Nómos é uma palavra grega que significa norma, lei, regra; logo, anomia é a ausência de regras.\n"
                            + "2. Anomia é uma doença biológica derivada de anemia.\n"
                            + "3. Nómos é uma palavra grega que significa norma, lei, regra; logo, anomia são as próprias leis.\n"
                            + "4. Nómos é uma palavra grega que significa norma, lei, regra; logo, anomia é o estado de espírito da sociedade.\n"
                            + "5. Com a anomia, a sociedade é mais pacífica.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 1 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Anormal é diferente de normal. Anormal é algo não-normal. (encontre a relação)\n");
                        } else if(resp == 1 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;

                for(i = 1; i <= 2; i++) {
                    System.out.println("O que são tribos urbanas?");
                    System.out.println("São tribos indígenas que entram para a sociedade urbana.\n"
                            + "2. Grupos de personalidades diversas dentro de apenas um grupo.\n"
                            + "3. Separação com valores e estilos culturais semelhantes.\n"
                            + "4. Agrupamento com valores e estilos culturais diferentes.\n"
                            + "5. Agrupamento com valores e estilos culturais semelhantes.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 5 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Rockeiros são uma tribo urbana, no qual existem elementos com os mesmos gostos, estilos e opiniões.\n");
                        } else if(resp == 5 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;

                for(i = 1; i <= 2; i++) {
                    System.out.println("Entre as nações que sofreram muito com visões etnocêntricas, estão:");
                    System.out.println("1. Africanos e europeus.\n"
                            + "2. Africanos e asiáticos.\n"
                            + "3. Norte-americanos e asiáticos.\n"
                            + "4. Europeus e asiáticos\n"
                            + "5. Europeus e norte-americanos.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 2 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Durante muito tempo, os asiáticos foram considerados inferiores, tendo uma sociedade ultrapassada.\n");
                        } else if(resp == 2 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.println("Pontuação parcial: "+pontAtual+"\n");
                resp = 0;

                for(i = 1; i <= 2; i++) {
                    System.out.println("Quais os significados mais aprofundados das palavras alemãs 'Kultur' e 'Zivilisation', com relação a cultura?");
                    System.out.println("1. Zivilization significa 'civilização' \n"
                            + "2. Kultur significa cultura.\n"
                            + "3.Kultur se refere aos aspectos materiais e Zivilization aos aspectos não materiais.\n"
                            + "4. Kultur se refere aos aspectos não materiais e Zivilisation aos aspectos materiais.\n"
                            + "5. Kultur e Zivilization são termos referentes a organização de uma sociedade.");
                    resp = (byte) t.nextInt();
                    if(resp > 0 && resp <= 5) {
                        if(resp != 2 && i == 1) {
                            System.out.println("Resposta errada.\nDica: Uns dependem dos outros.\n");
                        } else if(resp == 2 && i == 1) {
                            pontAtual += 100;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else if(resp == 3) {
                            pontAtual += 70;
                            System.out.println("\n --------------\n| VOCÊ ACERTOU |\n --------------");
                            break;
                        } else {
                            System.out.println("\n --------------\n| VOCÊ ERROU |\n --------------");
                        }
                    } else {
                        System.out.print("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                System.out.print("\n\nPONTUAÇÃO FINAL: "+pontAtual+"\n\n");
                resp = 0;
            }
            if(cont > 0) {
                if(pontAnterior > pontAtual) {
                    System.out.print("Você piorou "+(100-((pontAtual*100)/pontAnterior))+"% em relação à sua última pontuação.\n\n");
                } else if(pontAtual > pontAnterior) {
                    System.out.print("Você melhorou "+(100-((pontAnterior/pontAtual)*100))+"% em relação à sua última pontuação.\n\n");
                }
            }
            System.out.println("Deseja jogar novamente?      (1 - SIM, 2 - NÃO)");
            loop = (byte) t.nextInt();
            cont++; disc = 0;
        } while(loop == 1);
        System.out.print("\n Adeus");
    }
}