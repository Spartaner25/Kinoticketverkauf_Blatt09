package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public final class Geldbetrag {

	private final int _euro;
	private final int _cent;
	
	private Geldbetrag(int euro, int cent)
	{
		if (cent >= 100) {
			_cent = cent % 100;
			_euro = euro + cent /100;
		}
		else if (cent < 0)
		{
			_cent = 100+cent;
			_euro = euro - 1;
		}
		else {
			_cent = cent;
			_euro = euro;
		}
	}
	
	public int euro()
	{
		return _euro;
	}
	
	public int cent()
	{
		return _cent;
	}
	
	public static Geldbetrag valueOf(int euro, int cent) {
		return new Geldbetrag(euro, cent);
	}

	public Geldbetrag add(Geldbetrag geldbetrag) {
		int euronew = _euro + geldbetrag.euro();
		int centnew = _cent + geldbetrag.cent();
		return Geldbetrag.valueOf(euronew, centnew);
	}

	public Geldbetrag sub(Geldbetrag geldbetrag) {
		int euronew = _euro - geldbetrag.euro();
		int centnew = _cent - geldbetrag.cent();
		return Geldbetrag.valueOf(euronew, centnew);
	}

	public Geldbetrag mul(int mult) {
		int euronew = _euro * mult;
		int centnew = _cent * mult;
		return Geldbetrag.valueOf(euronew, centnew);
	}

	public Geldbetrag strconv(String string) {
		return null;
	}
	
	@Override
	public String toString()
	{
		if (_cent < 10) {
			return ""+_euro+",0"+_cent;
		} else {
			return ""+_euro+","+_cent;
		}
	}

	public Geldbetrag intconv(int geldbetrag) {
		int euronew = geldbetrag / 100;
		int centnew = geldbetrag % 100;
		return Geldbetrag.valueOf(euronew, centnew);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof Geldbetrag) && equals((Geldbetrag) obj);
	}
	
	public boolean equals(Geldbetrag geldbetrag)
	{
		return _euro==geldbetrag._euro&&_cent==geldbetrag._cent;
	}

}
