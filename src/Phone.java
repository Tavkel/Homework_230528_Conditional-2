public class Phone
{
	private final int _osId;
	private final int _clientDeviceYear;

	public Phone(int osId)
	{
		this._osId = osId;
		this._clientDeviceYear = 0;
	}
	public Phone(int osId, int clientDeviceYear)
	{
		this._osId = osId;
		this._clientDeviceYear = clientDeviceYear;
	}

	public String getDeviceOS()
	{
		switch (this._osId)
		{
			case 0:
				return "iOS";
			case 1:
				return "Android";
			default:
				return null;
		}
	}
	public int getDeviceYear()
	{
		return _clientDeviceYear;
	}
}