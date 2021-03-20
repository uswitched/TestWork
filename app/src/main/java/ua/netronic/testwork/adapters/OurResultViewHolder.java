package ua.netronic.testwork.adapters;

import androidx.recyclerview.widget.RecyclerView;

import ua.netronic.testwork.databinding.ItemUserListRecyclerBinding;
import ua.netronic.testwork.fragments.UserListFragment;
import ua.netronic.testwork.models.OurResult;

public class OurResultViewHolder extends RecyclerView.ViewHolder {
    private ItemUserListRecyclerBinding binding;

    public  OurResultViewHolder(ItemUserListRecyclerBinding binding, UserListFragment usersFragment) {
        super(binding.getRoot());
        this.binding = binding;
        binding.setHandler(usersFragment);
    }

    public void bind(OurResult ourResult) {
        binding.setResult(ourResult);
        binding.executePendingBindings();
    }
}
