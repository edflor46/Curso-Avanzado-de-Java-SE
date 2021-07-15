# Curso Avanzado de Java SE

Conversión de clases Abstractas del proyecto previamente realizado.

### Abstract clase Film
<pre>
    <code>public abstract class Film {...}</code>
</pre>

### Método Abstract clase Film
<pre>
    <code>public abstract void view();</code>
</pre>

## Implementando métodos abstractos en Java

**view() clase Movie**
<pre>
    <code>
    @Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}
		
		//Termine de verla
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + toString());
		System.out.println("Por: " + getTimeViewed() + " milisegundos");
		
	}</code>
</pre>

**view() clase Chapters**
<pre>
    <code>	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		ArrayList<Chapter> chapters =  getSerie().getChapters();
		int chapterViewedCounter = 0;
		
		for (Chapter chapter : chapters) {
			if (chapter.getIsViewed()) {
				chapterViewedCounter ++;
			}
		}
		
		if (chapterViewedCounter == chapters.size()) {
			getSerie().setViewed(true);
		}
	}</code>
</pre>

**view() clase Book**
<pre>
    <code>	public void view() {
		setReaded(true);
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}
		
		//Termine de verla
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("LeÃ­ste: " + toString());
		System.out.println("Por: " + getTimeReaded() + " milisegundos");
	}</code>
</pre>

### Demo

**Clase Movie**
![movie](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626316221/Academia-Java.-CDMX/Java-Avanzado/metodo_1_rdjl3o.png)

**Clase Book**
![serie](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626316221/Academia-Java.-CDMX/Java-Avanzado/metodo_3_et3zvt.png)

**Clase Serie**
![Serie](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626316221/Academia-Java.-CDMX/Java-Avanzado/metodo_2_gboljh.png)

## Javadoc
### Documentación Javadoc

![documentacion](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626320568/Academia-Java.-CDMX/Java-Avanzado/javadoc_w45l3o.png)