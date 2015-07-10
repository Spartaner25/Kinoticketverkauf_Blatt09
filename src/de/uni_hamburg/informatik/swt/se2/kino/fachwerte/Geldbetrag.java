package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public final class Geldbetrag {

	private final int _eurocent;
	
	private Geldbetrag(int eurocent)
	{
		_eurocent = eurocent;
	}
	
	public int euro()
	{
		return _eurocent / 100;
	}
	
	public int cent()
	{
		return _eurocent % 100;
	}
	
	public int eurocent()
	{
		return _eurocent;
	}
	
	public static Geldbetrag valueOf(int euro, int cent) {
		int eurocent = euro * 100 + cent;
		return new Geldbetrag(eurocent);
	}
	
	public static Geldbetrag valueOf(int eurocent) {
		return new Geldbetrag(eurocent);
	}

	public Geldbetrag add(Geldbetrag geldbetrag) {
		int eurocent = _eurocent + geldbetrag.eurocent();
		return Geldbetrag.valueOf(eurocent);
	}

	public Geldbetrag sub(Geldbetrag geldbetrag) {
		int eurocent = _eurocent - geldbetrag.eurocent();
		return Geldbetrag.valueOf(eurocent);
	}

	public Geldbetrag mul(int mult) {
		int eurocent = _eurocent * mult;
		return Geldbetrag.valueOf(eurocent);
	}
	
	public boolean kleinerGleich(Geldbetrag geldbetrag)
	{
		return _eurocent <= geldbetrag.eurocent();
	}

	public static Geldbetrag strconv(String eingabe) throws NumberFormatException
	{
		if (morethan(1, eingabe, ','))
		{
			throw new NumberFormatException();
		}
		String[] zahlen = eingabe.split("[,]");
		if (eingabe.contains(",") && zahlen.length > 1)
		{
			int euronew = Integer.parseInt(zahlen[0]);
			int centnew = 0;
			if (!zahlen[1].isEmpty())
			{
				if(zahlen[1].length()==1)
				{
					centnew = Integer.parseInt(zahlen[1])*10;
				}
				else
				{
					centnew = Integer.parseInt(zahlen[1]);
				}
			}
			return Geldbetrag.valueOf(euronew, centnew);
		}
		else
		{
			return Geldbetrag.valueOf(Integer.parseInt(eingabe) * 100);
		}
	}
	
	private static boolean morethan(int occ, String haystack, char needle)
	{
		int count = 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle)
			{
				count++;
			}
		}
		return count > occ;
	}
	
	@Override
	public String toString()
	{
		int euro = euro();
		int cent = cent();
		String cent1;
		if (cent() < 0)
		{
			euro = euro * -1;
			cent = cent * -1;
		}
	if ((cent() < 10 && cent() >= 0) || (cent() > -10 && cent() < 0))
		{
			cent1 = "0"+cent;
		} 
		else
		{
			cent1 = ""+cent;
		}
		return euro+","+cent1;
	}

	public static Geldbetrag intconv(int geldbetrag) {
		return Geldbetrag.valueOf(geldbetrag);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof Geldbetrag) && equals((Geldbetrag) obj);
	}
	
	public boolean equals(Geldbetrag geldbetrag)
	{
		return eurocent() == geldbetrag.eurocent();
	}

}
