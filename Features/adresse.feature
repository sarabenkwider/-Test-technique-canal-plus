Feature: Modifier l'adresse d'un abonné
    
   Scenario: Modification de l'adresse d'un abonné résidant en France sans date d'effet
      Given  Un abonné avec une adresse principale active en France
      When   Le conseiller connecté à canal modifie l'adresse de l'abonné sans date d'effet
      Then   L'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné
      And    Un mouvement de modification d'adresse est créé