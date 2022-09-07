# Kubernetes (k8s) e Red Hat OpenShift Container Platform (OCP) #

## Índice ##

- [ Introdução ](#introducao)
- [ Pods ](#pods)
- [ Services ](#services)
- [ Config Maps ](#configmaps)
- [ Secrets ](#secrets)
- [ ReplicaSets ](#replicasets)
- [ Deployments ](#deployments)
- [ Volumes ](#volumes)
- [ Persistent Volume ](#persistentvolume)
- [ Persistent Volume Claims ](#persistentvolumeclaims)
- [ Storage Classes ](#storageclasses)
- [ Operators ](#operators)
- [ Deployment Configs (OCP) ](#deploymentconfigs)
- [ ReplicationControllers ](#replicationcontrollers)
- [ Routes ](#routes)
- [ Network Policies ](#networkpolicies)
- [ Build Configs ](#buildconfigs)
- [ ImageStreams ](#imagestreams)
- [ Resource Quotas ](#resourcequotas)

<a name="introducao"></a>
### Introdução ###

O Kubernetes, ou simplesmente k8s, é um projeto open source de Orquestração de Containers criado pela Google. Anunciado em 2014 e em 2015 doado para Cloud Native Computing Foundation, que é um braço da Linux Foundation.

A ideia do Kubernetes é trazer mais poder à gerência do cluster, criando diversos facilitadores, como por exemplo, Load Balancers.

<a name="pods"></a>
### Pods ###

O Pod é a menor unidade quando se fala em Kubernetes. Na maioria dos casos tem somente um container em sua composição, mas é possível ter mais do que um. Resumindo, no kubernetes quando queremos criar containers, criamos na verdade pods, e declaramos os containers dentro dos pods.

Existe a possibilidade de gerenciarmos os pods de maneira imperativa e declarativa.

No mundo do Kubernetes, a depender da funcionalidade que iremos utilizar, precisamos especificar qual a versão da api pretendemos utilizar. Está tudo documento no link: https://kubernetes.io/docs/concepts/overview/kubernetes-api/.

Referência: https://kubernetes.io/docs/concepts/workloads/pods/

<a name="services"></a>
### Services ###

Os Services possibilitam a utilização de um ip fixo dentro da nossa rede de kubernetes, dns para um pod ou até para um conjunto de pods. Essa ideia de conjunto de pods, inclusive já é a porta de entrada para os Load Balancers.

Os tipos de Services são:

    ClusterIP: tem como objetivo facilitar a comunicação interna entre os pods com um ip fixo.
    NodePort: tem como objetivo expôr a porta de um nó do cluster utilizando NAT entre o ip porta do nó com um conjunto de ClusterIP.
    LoadBalancer: tem como objetivo expôr uma porta com IP fixo para o mundo externo englobando um conjunto de NodePort e também criando um balanceador de cargas.

Referência: https://kubernetes.io/pt-br/docs/tutorials/kubernetes-basics/expose/expose-intro/

<a name="configmaps"></a>
### Config Maps ###

O Config Map é um objeto que visa o armazenamento de dados não confidenciais como variáveis de ambiente.
Como o ConfigMap não possui encriptação, quando se trata de dados que não podem estar expostos, o ideal é utilizar Secrets.
A maneira de utilizar ConfigMaps pode ser como argumento de linha de comando ou o referenciando na declaração do componente.

Referência: https://kubernetes.io/pt-br/docs/concepts/configuration/configmap/

<a name="secrets"></a>
### Secrets ###

Os Secrets já são mais indicados para situações onde o objetivo é guardar dados confidenciais como senha de banco, tokens ou chaves. A vantagem está em não precisar incluir esses dados dentro do código e sim só referenciá-los como uma variável de ambiente.

Referência: https://kubernetes.io/pt-br/docs/concepts/configuration/secret/

<a name="replicasets"></a>
### ReplicaSets ###

Os pods são efêmeros e quando os criamos, não temos garantia de que ele esteja sempre disponível. Caso um pod nosso de nginx cair por algum motivo, ele não voltará mais. Conseguimos resolver esse problema com os ReplicaSets, trazendo proatividade ao nosso cluster. Dentro do nosso RS, podemos ter um ou mais pods. Inclusive configurar um número mínimo, um número máximo e um número desejado de pods.
Apesar de já parecer uma boa solução para o problema, a própria documentação de Kubernetes indica a utilização de Deployments.

Referência: https://kubernetes.io/docs/concepts/workloads/controllers/replicaset/

<a name="deployments"></a>
### Deployments ###

Os Deployments são nada mais nada menos do que uma camada acima de um ReplicaSet. Nos traz diversas outras features interessantes, como por exemplo, um histórico do que acontece com os nossos pods. Caso alteremos a versão da imagem que o pod está utilizando, irá gerar uma revisão, como um commit ou uma tag em um repositório git. Isso nos dá a possibilidade de voltar para determinada versão.

Referência: https://kubernetes.io/docs/concepts/workloads/controllers/deployment/

<a name="volumes"></a>
### Volumes ###

Assim como em containers docker, os nossos pods são efêmeros e ao deletarmos o pod, ou até mesmo ele cair por algum motivo, perderíamos os dados. Podemos utilizar Volumes para resolver esse problema. Outra situação também resolvida é de quando existem arquivos compartilhados entre containers dentro de um mesmo pod.

Um ponto importante sobre os Volumes são os tipos. O mais trivial é o hostPath, que nos possibilita linkar um arquivo ou um diretório da máquina host com um arquivo ou diretório dentro do pod. Já o awsElasticBlockStore nos permite criar um volume entre o nosso pod e um EBS no AWS.

Referência: https://kubernetes.io/docs/concepts/storage/volumes/

<a name="persistentvolume"></a>
### Persistent Volume ###

A ideia de Persistent Volumes é separar o gerenciamento de armazenamento do gerenciamento dos nossos pods.
Possui um ciclo de vida independente dos pods, ou seja, é possível criar o PV mesmo sem criar um pod.

Existem duas maneiras de provisionar PVs, de maneira estática e de maneira dinâmica.
A maneira estática se dá por um arquivo de definição especificando exatamente o PV que deve ser criado. Já a dinâmica se dá por StorageClasses.

Após o PV criado, a maneira que utilizamos para conseguir utilizar esse PV em determinado pod é utilizando Persistent Volume Claims.

Referência: https://kubernetes.io/docs/concepts/storage/persistent-volumes/

<a name="persistentvolumeclaims"></a>
### Persistent Volume Claims ###

A maneira de fazer o binding de um PV com um Pod é utilizando Persistent Volume Claims. Com o PVC, conseguimos requisitar os recursos que o PV disponibiliza. É possível, por exemplo, solicitar somente leitura a um determinado PV, ou que somente um pod por vez possa acessar esse PV.

Referência: https://kubernetes.io/docs/concepts/storage/persistent-volumes/
Storage Classes
Com StorageClass conseguimos provisionar dinamicamente um disco em um Cloud Provider.

Referência: https://kubernetes.io/docs/concepts/storage/storage-classes/

<a name="replicationcontrollers"></a>
### ReplicationControllers ###

<a name="deploymentconfigs"></a>
### Deployment Configs ###

<a name="operators"></a>
### Operators ###

<a name="routes"></a>
### Routes ###

<a name="networkpolicies"></a>
### Network Policies ###

<a name="buildconfigs"></a>
### Build Configs ###

<a name="imagestreams"></a>
### ImageStreams ###

<a name="resourcequotas"></a>
### Resource Quotas ###

NERD ALERT!

Fato curioso!

O nome Kubernetes deriva de uma palavra grega para Timoneiro, o responsável por conduzir um navio. Eis o motivo da logo ser um timão. Esse timão tem 7 lados como uma referência a personagem Sete da Série Star Trek. A mesma era uma Borg, e Borg ou Google Borg é um gerenciador de cluster onde muitos dos principais contribuintes do k8s trabalharam.