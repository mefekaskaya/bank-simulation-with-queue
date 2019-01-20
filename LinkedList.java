
public class LinkedList {

	private Node head;

	public LinkedList() {
		this.head = null;
	}

	public void priorityInsert(Node newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		else if (this.head != null) {
			int place = 0;
			int sequence = 0;
			boolean isInQueue = false;
			Node temp = this.head;
			boolean isInserted = false;
			int index = 0;

			while (temp != null) {
				if (temp.getPriority() == 0) {
					isInQueue = true;
					sequence = 0;
					do {
						place = index;
						sequence++;
						temp = temp.getNext();
						index++;
					}while(temp != null && temp.getPriority() == 0);
				}
				else {
					temp=temp.getNext();
					index++;
				}
			}

			if (newNode.getPriority() == 0) { // Yeni Eklenen 0 ise
				if (!isInQueue) {
					newNode.setNext(this.head.getNext());
					this.head = newNode;
				}
				else {
					if (sequence < 5) {
						temp = this.head;
						for (int i = 0; i < place; i++) {
							temp = temp.getNext();
						}
						newNode.setNext(temp.getNext());
						temp.getNext().setPrev(newNode);
						temp.setNext(newNode);
						newNode.setPrev(temp);
					}
					else {
						temp = this.head;
						while(temp.getNext() != null) {
							temp = temp.getNext();
						}
						temp.setNext(newNode);
						newNode.setPrev(temp);
					}
				}
			}
			else if (newNode.getPriority() == 1) {  // Yeni Eklenen 1 ise
				boolean flag = false;
				temp = this.head;
				if (isInQueue) {
					for (int i = 0; i < place; i++) {  // temp en son 0 g�r�len yere �ekildi
						temp = temp.getNext();
					}
				}
				if (temp.getNext() == null) { // yan� bo�sa direk ekle
					temp.setNext(newNode);
					newNode.setPrev(temp);
				}
				else {
					temp = temp.getNext();
					while(temp != null) {

						if (temp.getPriority() == 2) { 	 						//elimdeki temp 2 ise
							if (temp.getPrev().getPriority() != 1) { 			// �nceki 1 de�ilse
								newNode.setNext(temp);
								newNode.setPrev(temp.getPrev());  				//ekle
								temp.getPrev().setNext(newNode);
								temp.setPrev(newNode);
								flag = true;
								break;
							}
							else { 												
								if (temp.getNext() == null) {					// sonraki bo�sa ekle
									temp.setNext(newNode);
									newNode.setPrev(temp);
									flag = true;
									break;
								}
								else {
									while(temp != null && temp.getPriority() == 2) {// �nceki 1 ise 2 leri ge�
										temp = temp.getNext();
									}
								}
							}
						}

						else if (temp.getPriority() == 3) {						// elimdeki temp 3 ise
							if (temp.getPrev().getPriority() != 1) {			// �nceki 1 de�ilse
								newNode.setNext(temp);
								newNode.setPrev(temp.getPrev());				//ekle
								temp.getPrev().setNext(newNode);
								temp.setPrev(newNode);
								flag = true;
								break;
							}
							else {
								if (temp.getNext() == null) {					// sonraki bo�sa ekle
									temp.setNext(newNode);
									newNode.setPrev(temp);
									flag = true;
									break;
								}
								else {
									while(temp != null && temp.getPriority() == 3) {// �nceki 1 ise 3 leri ge�
										temp = temp.getNext();
									}
								}
							}
						}

						else if (temp.getPriority() == 1) {						// elimdeki temp 1 ise
							int count = 0; //ka� adet 1 oldu�unu sayacak
							Node seqTemp = temp; //sayd�rma yaparken temp i bozmamak i�in kulland���m ge�ici node
							while (seqTemp != null && seqTemp.getPriority() == 1) { // seqTemp 1 oldu�u s�rece say
								count++;
								seqTemp = seqTemp.getNext();
							} 

							if (count < 3) { // 1 lerin say�s� 3 ten k���kse 
								for (int i = 0; i < count-1; i++) { // temp i do�ru yere getir
									temp = temp.getNext();
								}
								if (temp.getNext() != null) {
									newNode.setNext(temp.getNext()); // ekle
									temp.getNext().setPrev(newNode);
								}
								temp.setNext(newNode);
								newNode.setPrev(temp);
								flag = true;
								break;
							}
							else {
								break;
							}
						}

					}
					if (!flag) { // hi� ekleme yap�lmad�ysa sona ekle
						temp = this.head;
						while (temp.getNext() != null) {
							temp = temp.getNext();
						}
						temp.setNext(newNode);
						newNode.setPrev(temp);
					}
				}
			}
			else if (newNode.getPriority() == 2) {  // Yeni Eklenen 2 ise
				boolean flag = false;
				temp = this.head;

				if (isInQueue) { // ba�lang�� olarak enson 0 � kabul etme �ekli
					for (int i = 0; i < place; i++) {
						temp = temp.getNext();
					}
				}
				if (temp.getNext() == null) {
					temp.setNext(newNode);
					newNode.setPrev(temp);
				}
				else {
					temp = temp.getNext();
					while (temp != null) {
						if (temp.getPriority() == 1) { // elimdeki 1 ise
							while(temp.getPriority() == 1) { // 1 leri ge�
								temp = temp.getNext();
							}
						}
						else if (temp.getPriority() == 2) { // elimdeki 2 ise
							int count = 0;
							Node seqTemp = temp;
							while (seqTemp != null && seqTemp.getPriority() == 2) { //2 leri sayd�r
								count++;
								seqTemp = seqTemp.getNext();
							} 

							if (count < 2) { // 2 den k���kse
								if (temp.getNext() != null) {
									newNode.setNext(temp.getNext()); // ekle
									temp.getNext().setPrev(newNode);
								}
								temp.setNext(newNode);
								newNode.setPrev(temp);
								flag = true;
								break;
							}
							else {
								break;
							}

						}
						else if (temp.getPriority() == 3) {
							if (temp.getPrev().getPriority() != 2) {
								temp = temp.getPrev();
								newNode.setNext(temp.getNext());
								newNode.setPrev(temp);
								temp.getNext().setPrev(newNode);
								temp.setNext(newNode);
								flag = true;
								break;
							}
							else {
								temp = temp.getNext();
							}
						}
					}
					if (!flag) { // hi� ekleme yap�lmad�ysa sona ekle
						temp = this.head;
						while (temp.getNext() != null) {
							temp = temp.getNext();
						}
						temp.setNext(newNode);
						newNode.setPrev(temp);
					}
				}
			}
			else if (newNode.getPriority() == 3) {   // Yeni Eklenen 3 ise
				temp = this.head;
				while(temp.getNext() != null) {
					temp = temp.getNext();
				}
				temp.setNext(newNode);
				newNode.setPrev(temp);
			}
		}
	}

	public void insert(Node node) {
		Node temp;
		if (this.head != null) {
			temp = this.head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setPrev(temp);
		}
		else {
			this.head = node;
		}
	}

	public void remove() {
		if (this.head != null && this.head.getNext() != null) {
			this.head = this.head.getNext();
		}
		else if(this.head != null && this.head.getNext() == null) {
			this.head = null;
		}
		else {
			System.out.println("queue already empty");
		}
	}

	public void print() {
		Node temp = this.head;
		while (temp != null) {
			System.out.println(temp.getName() + " -> " + temp.getPriority());
			temp = temp.getNext();
		}
	}

	public Node getHead() {
		return this.head;
	}

	public void setHead(Node head) {
		this.head = head;
	}


}
