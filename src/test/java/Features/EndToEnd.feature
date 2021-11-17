# language: pt
# encoding: utf-8

  Funcionalidade: End to End

    Cenario: login válido
      Dado que o usuario esta na pagina de login
      Quando insere os dados validos para login
      Entao deve acessar a plataforma

    Cenario: adicionar produto ao carrinho
      Dado que o usuario esta na pagina de produtos
      Quando seleciona o produto desejado
      Entao os produtos devem ser adicionados ao carrinho

    Cenario: realizando Checkout
      Dado que usuário adicionou  o produto desejado ao carrinho
      Quando clica no botao Checkout
      Entao deve ser direcionado para a pagina Checkout Your Information

    Cenario: registrando dados pessoais
      Dado que o usuario esta na pagina de checkout
      Quando insere suas informações pessoais
      E clica no botao Continue
      Então deve ser direcionado para a pagina Overview

    Cenario: finalizando a compra
      Dado que o usuario selecionou o produto
      E inseriu suas informaçoes na pagina de checkut
      Quando clica no botao Finish na pagina Checkout Step Two
      Então deve ser direcionada para a pagina Complete