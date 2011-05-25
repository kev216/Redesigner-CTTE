package zone;

public interface I_PublishSelected {
	
	public void addSelectedListener(I_SelectedListener listener);
	public void removeSelectedListener(I_SelectedListener listener);
	public void upDate(Object o);

}
