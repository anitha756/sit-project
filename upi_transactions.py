def init(self,name,up_id,bank_acc):
  self.name=name
  self.upi_id=upi_id
  self.bank_acc=bank_acc
  transaction=Transaction(user1,user2,50000)
  print(transaction.make_transaction())
